# 《统计自然语言处理》——宗成庆

自然语言处理理性主义方法：(rationalist)
1. **基于规则的方法(rule-based approach)**: 有限状态转移网络,有限状态转录机,递归转移网络,扩种转移网络,短语结构语法,自底向上剖析,自顶向下剖析,左角分析法,Earley算法,CYK算法,富田算法,复杂特征分析法,合一运算,依存语法,一阶谓词演算,框架网络
2. **基于统计方法(statistic-based approach)**:隐马克尔夫模型(hidden Markov model ,HMM),最大熵模型,n元语法(n-gram),概率上下文无关语法,噪声信道理论,贝叶斯方法,最小编辑距离算法,Viterbi算法,A*搜索算法,双向搜索算法,加权自动机,支持向量机(SVM)

**反思:**
1. 重新评价有限状态模型
2. 重新回到"经验主义" (empiricist)

总结: 要把"理性主义"和"经验主义"相结合

## 自然语言处理研究内容

1. 机器翻译 MT - Machine Translation
2. 自动文摘 Automatic Summarizing/ Automatic Abstraction : 文章主要内容的提炼
3. 信息检索 Information Retrieval - 海量文档中搜素需要的内容; (cross-language/trans-lingual info retrieval)跨语言信息检索
4. 文档分类 Document Categorization/classification,也叫 info Categorization/classification:根据主题或者内容对文章进行分类 → 情感分析(sentiment classification) →了解用户对产品的评价/分析网民对某件政治事件的看法 →  用于支撑舆情分析(public opinion analysis)的重要基础.
5. 问答系统 Question Answering System: 对用户提出的问题进行回答
6. 信息过滤 Information Filtering:　自动识别和过滤满足条件的信息 → 用于信息安全,和内容管理等
7. 信息抽取 Information Extraction: 从文本中抽取特定事件,包括时间,地点,产品名称,开发时间,某些性能指标等等. 可以提高信息检索的性能
8. 文本挖掘 Text Mining:(又称data mining), 从文本中*提取高质量信息*的过程;一般涉及
  - 文本分类
  - 文本聚类(text clustering)
  - 概念或实体抽取(concept/entity extraction)
  - 粒度分析
  - 情感分析(sentiment analysis)
  - 自动文摘
  - 实体关系建模(entity relation modeling)
9. 舆情分析 Public Opinion Analysis: 命中对社会管理者产生和持有的社会政治态度,来源有:新闻评论,网络论坛(bulletin board system BBS), 聊天室, Blog, Sina微博, 聚合新闻, Facebook, QQ, Twitter等社交网站, 其中需要用到的技术有: 文本挖掘,观点挖掘(opinion mining)等问题.
10. 隐喻计算 Metaphorical Computation 就是用乙事务或者其某些特征来描述甲事务的特征
11. 文字编辑和自动校对 Automatic Proofreading: 文字拼写,用词,语法,文档格式校对
12. 作文自动评分 对文章质量进行打分
13. 光读字符识别 Optical Character Recognition (OCR), 计算机对印刷系统的识别
14. 语音识别 Speech Recognition: 也叫做 Automatic Speech Recognition(ASR)
15. 文语转换 Text to speech conversion: 书面文本自动转换成对应语音表特征
16. 说话人识别/认证/验证 speaker recognition/identification/verification: 对说话人的语言样本进行分析,判断说话人的身份.

### 自然语言面临的困难:
1. 歧义:  
  - Stop word:  Prof. Zhang 里面的点不是句号,而是缩写
  - 中文分词会有不同的含义: 自动化研究所取得的成就:自动化/研究/所/取得/的/成就.  自动化/研究所/取得/的/成就 | 会有不同的含义


## 语料库(Corpus Base)

**定义**: 就是存放语言材料的数据库; 语料库语言学(corpus linguistics)就是基于语料库进行语言学习研究;

**语料库的分类:**
1. 按照语种划分:单语种语料库, 多语种语料库
2. 按记载媒体不同划分:单媒体语料库, 多媒体语料库
3. 地域划分:国家语料库, 国际语料库

**语料库的对比:**
1. 平衡语料库(banlanced corpus) v.s 平行语料库(parallel corpus)
2. 通用语料库,语专用语料库
3. 共时语料库与历时语料库
4. 生语料与标注语料哭: 生语料(corpora with raw data), 没有进行任何处理的数据,不加任何标注信息; 标注语料库又可以细分为 分词语料库(汉语)/分词与词性标注语料库/树库(tree bank)/命题库(proposition bank)/篇章树库(discourse tree bank)

**典型语料库介绍**
1. LDC中文树库(Chinese Tree Bank, CTB) [link](http://www.cis.upenn.edu/~chinese/ctb.html)
2. 命题库,名词化树库[[1]](http://nlp.cs.nyu.edu/meyers/NomBank.html),语篇库[[2]](http://www.seas.upenn.edu/~pdtb/)
3. 布拉格依存树库(Prague Dependency Treebank, PDT) [link](http://www.elsnet.org/nps/0040.html)
4. BTEC 口语语料:由国际语音翻译先进研究联盟(Consortium for Speech Translation Advanced Research, C-STAR) 开发.[link](http://www.c-star.org)
5. 现代汉语语料库
6. 台湾中研究院语料库: 建立了 汉语平衡语料库(Sinica Corpus)[[1]](http://www.sinica.edu.tw/SinicaCorpus/) 和 汉语树库)(Sinica Treebasnk) [[2]](http://godel.iis.sinica.edu.tw/CKIP/engversion.treebank.htm)

**语言知识库**
语言知识库比语料库包含更广泛的内容.
概括起来讲,语言知识库有两种:
1. 词典,规则库, 语义概念库. 语言知识的表现是 **显性** 的.
2. 另一个存在于语料库之中, 每个语言单位的出现,范畴意义用法都是去顶的.
而语料库,每个句子都是线性的非结构化文字序列,包含的知识都是 **隐形** 的.

**语言知识库举例:**
1. WordNet: 按照语义关系网络组织的巨大词库
2. FrameNet: 基于框架语义学(frame semantics) 并以语料库为基础建立的在线英语词汇资源库.
3. EDR:日语词典
4. 北京大学综合型语言知识库: 目前国际上规模最大且获得广泛认可的汉语语言知识库.
5. 知网(HowNet)
6. 概念层次网络(Hierarchical Network of Concepts, HNC)

## 语言模型
> 目前主流采用 n元语法(n-gram)模型,简单直接,但因为数据缺乏而必须采取平滑(smoothing)算法

to-be continue..
2019-7-31 Wed
