from konlpy.tag import Komoran
import pickle

class Preprocess:
    #userdic : 사용자 사전
    def __init__(self, word2index_dic='',userdic=None):
        # 단어 인덱스 사전 불러오기
        if word2index_dic != '':
            f = open(word2index_dic, 'rb')
            self.word_index = pickle.load(f)
            f.close()
        else:
            self.word_index = None
            
        # 형태소 분석기 초기화 
        self.komoran = Komoran(userdic=userdic)
        # 제외시킬 품사 정의 (불용어 정의)
        # 조사(J), 기호(S), 어미(E), 접미사(X)
        self.exclusion_tags = ['JKS', 'JKC', 'JKG', 'JKO', 'JKB', 'JKV',
                               'JKQ', 'JX', 'JC', 'SF', 'SP', 'SS', 'SE',
                               'SO', 'EP', 'EF', 'EC', 'ETN', 'ETM', 'XSN',
                               'XSV', 'XSA']
        
    def pos(self, sentence):
        return self.komoran.pos(sentence)
    
    # 불용어 제거 후, 핵심 키워드 가져오기
    def get_keywords(self, pos, without_tag=False):
        word_list = []
        for p in pos:
            if p[1] not in self.exclusion_tags:
                word_list.append(p[0] if without_tag else p)
        return word_list
    
    def get_wordidx_sequence(self, keywords):
        if self.word_index == None:
            return []
        w2i = []
        for word in keywords:
            try:
                w2i.append(self.word_index[word[0]])
            except KeyError:
                w2i.append(self.word_index['OOV'])
        return w2i