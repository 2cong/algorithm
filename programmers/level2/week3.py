# 방금그곡 (https://school.programmers.co.kr/learn/courses/30/lessons/17683#)
def time_to_min(time):
    hour, min = time.split(':')
    return int(hour) * 60 + int(min)


def reformat_code(code):
    reformatted_code = ""
    for i in range(0, len(code)):
        if i + 1 != len(code) and code[i + 1] == "#":
            reformatted_code += code[i].lower()
        elif code[i] == '#':
            continue
        else:
            reformatted_code += code[i].upper()

    return reformatted_code


class Music:
    def __init__(self, musicinfo):
        self.start_time = time_to_min(musicinfo[0])
        self.time = time_to_min(musicinfo[1]) - self.start_time
        self.name = musicinfo[2]
        self.code = reformat_code(musicinfo[3])
        self.total_code = self.code * (self.time // len(self.code)) + self.code[:self.time % len(
            self.code)] if self.time != 0 else ""

    def is_in_total_code(self, neo_code):
        return bool(neo_code in self.total_code)


def solution(m, musicinfos):
    answer = []
    music_infos = sorted([Music(musicinfo.split(',')) for musicinfo in musicinfos], key=lambda m: m.start_time)
    for music in music_infos:
        if music.is_in_total_code(reformat_code(m)):
            answer.append(music)

    if answer:
        answer = sorted(answer, key=lambda m: m.time, reverse=True)
        return answer[0].name

    else:
        return "(None)"