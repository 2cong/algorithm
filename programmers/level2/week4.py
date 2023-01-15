# 스킬트리(https://school.programmers.co.kr/learn/courses/30/lessons/49993)
def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        reformed_skill_tree = [sk for sk in skill_tree if sk in skill]
        reformed_skill_tree = ''.join(reformed_skill_tree)
        if reformed_skill_tree == skill[:len(reformed_skill_tree)]:
            answer += 1
    return answer


# 거리두기 확인하기(https://school.programmers.co.kr/learn/courses/3
class Checker:
    def __init__(self, place, x, y):
        self.place = place
        self.x = x
        self.y = y
        self.result = 1

    @property
    def y_side_place(self):
        y_side_place = ""
        for x in range(0, 5):
            y_side_place += self.place[x][self.y]

        return y_side_place

    def check_right(self):
        if self.place[self.x][self.y:][:3] == "POP" or self.place[self.x][self.y:][:2] == "PP":
            self.result = 0

    def check_down(self):
        if self.y_side_place[self.x:][:3] == "POP" or self.y_side_place[self.x:][:2] == "PP":
            self.result = 0

    def check_diagonal(self):
        if self.x <= 3 and self.y <= 3:
            if self.place[self.x + 1][self.y] != 'X' or self.place[self.x][self.y + 1] != 'X':
                if self.place[self.x + 1][self.y + 1] == 'P':
                    self.result = 0

        if self.result == 1 and self.x >= 1 and self.y <= 3:
            if self.place[self.x - 1][self.y] != 'X' or self.place[self.x][self.y + 1] != 'X':
                if self.place[self.x - 1][self.y + 1] == 'P':
                    self.result = 0

    def check(self):
        if self.result == 1:
            self.check_right()
        if self.result == 1:
            self.check_down()
        if self.result == 1:
            self.check_diagonal()
        return self.result


def solution(places):
    answer = []
    for place in places:
        place_result = 1
        people_idx = [(x, y) for x in range(0, 5) for y in range(0, 5) if place[x][y] == 'P']

        for x, y in people_idx:
            result = Checker(place, x, y).check()
            if result == 0:
                place_result = 0
                break
        answer.append(place_result)

    return answer
