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