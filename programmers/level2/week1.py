# 주차 요금 계산 (https://school.programmers.co.kr/learn/courses/30/lessons/92341)
import math
from collections import defaultdict


def calc_time(out_time, in_time):
    out_h, out_m = out_time.split(':')
    in_h, in_m = in_time.split(':')
    out_h, out_m, in_h, in_m = int(out_h), int(out_m), int(in_h), int(in_m),

    if in_m > out_m:
        out_h -= 1
        out_m += 60

    if (out_m - in_m) >= 60:
        during_t = (out_m - in_m) - 60
        out_h += 1
    else:
        during_t = (out_m - in_m)

    during_t = (out_h - in_h) * 60 + during_t
    return during_t


def get_fee(fees, during_time):
    fee = fees[1]
    if during_time > fees[0]:
        fee = fee + math.ceil((during_time - fees[0]) / fees[2]) * fees[3]
    return fee


def solution(fees, records):
    answer = []
    cars_records = defaultdict(list)
    for record in records:
        time, car_number, _ = record.split(' ')
        cars_records[car_number].append(time)

    sorted_cars_number = sorted(cars_records.keys())
    for car_number in sorted_cars_number:
        car_record = cars_records[car_number]

        during_time = 0
        while len(car_record) != 0:
            if len(car_record) == 1:
                in_time = car_record.pop(0)
                out_time = "23:59"
            else:
                in_time = car_record.pop(0)
                out_time = car_record.pop(0)
            during_time = during_time + calc_time(out_time, in_time)
        fee = get_fee(fees, during_time)
        answer.append(fee)

    return answer


# 튜플 (https://school.programmers.co.kr/learn/courses/30/lessons/64065)
def solution(s):
    s = s.split('},')
    tuples = []

    ordered_answer = {}

    for tuple_member in s:
        tuple_member = tuple_member.replace('{', '').replace('}', '').replace("'", '')
        tuple = [int(member) for member in tuple_member.split(',')]
        tuples.append(tuple)

    sorted_tuples = sorted(tuples, key=lambda t: len(t))

    for idx, tuple in enumerate(sorted_tuples):
        if idx == 0:
            ordered_answer[tuple[0]] = idx

        sorted_tuple = sorted(tuple, key=lambda t: ordered_answer.get(t, len(tuple)))
        ordered_answer[sorted_tuple[idx]] = idx

    answer = list(ordered_answer.keys())

    return answer