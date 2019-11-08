# -*- coding: utf-8 -*-
"""
Created on Wed Nov  6 11:26:50 2019

@author: shehy2

@description: 读取excel表格, 然后转化为训练数据, 用来做THUCTC的情感分类训练
"""

import openpyxl

wb = openpyxl.load_workbook('TrainingData.xlsx')
sheet = wb.get_sheet_by_name('TrainingData')
posCount=0
negCount=0

for row in range(0, 23543):
    title = sheet['A'+str(row)].value
    label = sheet['B'+str(row)].value
    #print(title)
    if(label == '__label__neg'):
        print("正在写入第%d条负面训练数据"%negCount)
        filename = str(negCount) + '.txt'
        textFile = open('neg/'+filename,'w',encoding='utf-8')
        textFile.write(str(title))
        textFile.close()
        negCount = negCount + 1
    else:
        print("正在写入第%d条正面训练数据"%posCount)
        filename = str(posCount) + '.txt'
        textFile = open('pos/'+filename,'w',encoding='utf-8')
        textFile.write(str(title))
        textFile.close()
        posCount = posCount + 1
    
print('写入完成')