#!/usr/bin/env python
# coding: utf-8

#环境: python 3.7.3


from wordcloud import WordCloud
import numpy
import PIL.Image as Image
import pandas as pd


#将csv读取为dict的文件(适用于已经统计好词频的csv,不用保留title)
#如果出现读取报错, 那么可能是: encoding部分出现问题,可更改 encoding='gbk',这里默认是utf-8
def csv_to_dict(file_name):
    import csv
    reader = csv.reader(open(file_name, 'r',encoding='gbk'))
    #返回的是一个字典, key = 关键词, value = 词频 (int类型)
    d = {}
    for row in reader:
       k, v = row
       d[k] = int(v)
    return d 
#随机生成颜色, 可以更改 h=randint(60,250) 里面60那个值,值越小,随机出来的颜色种类会越多
def random_color_func(word=None, font_size=None, position=None,  orientation=None, font_path=None, random_state=None):
    from random import randint
    h  = randint(20,250)
    s = int(100.0 * 255.0 / 255.0)
    l = int(100.0 * float(randint(60, 120)) / 255.0)
    return "hsl({}, {}%, {}%)".format(h, s, l)


'''
生成词云图的函数:
1. font_path = "simhei.ttf" 是自己下载的字体文件,如果要更换可以换成font_path="C:/Windows/Fonts/simfang.ttf"
    或者其他字体文件
2. 如果不需要随机颜色,注释掉color_func = random_color_func即可
3. 运行后会弹出一张图片, 直接保存即可
'''
def gen_wordcloud_from_dic(dic):
    #这里用了一张图片作为mask,如果不要mask, 注释掉mask=mask_pic,即可
    mask_pic=numpy.array(Image.open("msk.jpg"))
    wordcloud = WordCloud(background_color="white",
                          font_path="simhei.ttf",
                          max_words=2000,
                          width=2000,
                          height=1720,
                          margin=2,
                          mask=mask_pic,
                          #random_state=42,
                          collocations=False,
                          color_func = random_color_func
                         ).generate_from_frequencies(dic)
    image=wordcloud.to_image()
    image.show()

if __name__ == '__main__':
    dic = csv_to_dict("图8-S60L数据（好感用户）.csv")
    gen_wordcloud_from_dic(dic)

