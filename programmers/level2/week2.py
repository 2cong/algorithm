# 마법의 엘리베이터 (https://school.programmers.co.kr/learn/courses/30/lessons/148653)
class Elevator:
    def __init__(self, storey):
        self.storey = storey
        self.count = 0
        self.is_up = None

    def is_ground_floor(self):
        if self.storey == 0:
            return True
        return False

    def up(self, digit, number):
        count = 10 - number
        self.count += count
        self.storey += count * (10 ** (digit - 1))

    def down(self, digit, number):
        self.count += number
        self.storey -= number * (10 ** (digit - 1))

    def decide_up_down(self, digit, number):
        if number < 5 and number >= 1:
            self.is_up = False

        elif number == 5:
            if digit != len(str(self.storey)):
                upper_number = str(self.storey)[-(digit + 1)]
                self.decide_up_down(digit + 1, int(upper_number))
            else:
                if str(self.storey).replace('0', '') == '5':
                    self.is_up = False
                else:
                    self.is_up = True
        elif number == 0:
            self.is_up = False
        else:
            self.is_up = True

    def operate(self, digit, number):
        self.decide_up_down(digit, number)
        if self.is_up:
            self.up(digit, number)
        else:
            self.down(digit, number)


def solution(storey):
    elevator = Elevator(storey)
    if elevator.is_ground_floor():
        return elevator.count

    for digit in range(1, len(str(storey)) + 1):
        number = str(elevator.storey)[-digit]
        number = int(number)
        if number == 0:
            continue
        elevator.operate(digit, number)

    if elevator.is_ground_floor() is False:
        elevator.down(len(str(storey)) + 1, 1)

    return elevator.count


# 귤 고르기 (https://school.programmers.co.kr/learn/courses/30/lessons/138476)
from collections import Counter


def solution(k, tangerine):
    answer = 0
    tangerine_count = Counter(tangerine)
    sorted_tangerine_count = sorted(tangerine_count, key=lambda t: tangerine_count[t], reverse=True)

    for size in sorted_tangerine_count:
        count = tangerine_count[size]
        if k > 0:
            if count > k:
                k = 0
                answer += 1
                break
            elif count == k:
                k -= count
                answer += 1
                break
            else:
                k -= count
                answer += 1

    return answer