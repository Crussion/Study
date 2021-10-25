from konlpy.tag import Komoran

komoran = Komoran()
test = '아버지가 방에 들어갑니다.'

morphs = komoran.morphs(test)
print(morphs)
print('-' * 40)

pos = komoran.pos(test)
print(pos)
print('-' * 40)

nouns = komoran.nouns(test)
print(nouns)
print('-' * 40)