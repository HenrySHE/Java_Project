# -*- coding: utf-8 -*-
"""
Created on Sat Oct 26 10:11:32 2019

@author: shehy2
"""

#!/usr/bin/python3
 
import pymysql
import time
 

#获取当前月份数
month = time.strftime('%m',time.localtime(time.time()))
month = str(int(time.strftime('%m',time.localtime(time.time())))-1)
updateTime = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
# 打开数据库连接
db = pymysql.connect(host = " ",
                        user =" ",
                        port =  ,
                        password = " ",
                        db = " ")
 
# 使用cursor()方法获取操作游标 
cursor = db.cursor()
 
# SQL 查询语句
sql =(( "SELECT a.dealer_circle_code, b.dealer_circle, count(DISTINCT a.dealer_id) AS num FROM t_dealer_custom a LEFT JOIN t_dealer_circle b ON a.dealer_circle_code = b.dealer_circle_code WHERE a.platform_id IN (0, 101) AND a.created_time <= '2019-%s-31 23:59:59' AND a.updated_time >= '2019-%s-01 00:00:00' GROUP BY a.dealer_circle_code, b.dealer_circle ORDER BY num")%(month,month))
print(sql)
try:
   # 执行SQL语句
   cursor.execute(sql),
   # 获取所有记录列表
   updateList = []
   circleResultList = cursor.fetchall()
   for row in circleResultList:
      if (row[2] < 8 and row[2] > 0 and row[0] != ''):
         updateList.append({
            'dealerId':row[0],
            'dealerName':row[1],
            'pointCount': row[2]
         })
   print('经销商小于8的点为:')
   print(updateList)
   print('现在开始去除对应的点:')
   #SELECT * FROM t_dealer_custom WHERE dealer_circle_code = 456 AND platform_id IN (0, 101) AND created_time <= '2019-09-31 23:59:59' AND updated_time >= '2019-09-01 00:00:00';
   sql3 = "UPDATE t_dealer_custom SET dealer_circle_code = '' WHERE dealer_circle_code = %s AND platform_id IN (0, 101) AND created_time <= '2019-%s-31 23:59:59' AND updated_time >= '2019-%s-01 00:00:00';"
   
   updateVal = set()
   for dictItem in updateList:
       dealerId = dictItem['dealerId']
       val = (dealerId,month,month)
       updateVal.add(val)
   print (updateVal)
   """
   print ('开始更新点')
   for item in updateVal:
       print(sql3%(item))
       try:
           print('执行更新操作'+str(item))
           cursor.execute(sql3,item)
           
           db.commit()
       except:
           print('更新点失败')
           db.rollback()
   """
       
   filename = '清除商圈小于8个经销点的SQL语句(10月).txt'
   with open(filename,'w') as fileObj:
      for item in updateVal:
         sqlLine = (sql3%item)+'\n'
         #print(sql)
         fileObj.write(sqlLine)
         print("清空商圈号为%s的点已提交!"%(item[0]))
   #print(sql2)
   #cursor.execute(sql2)
   #db.commit()
   print("更改请求已完成!")

except:
   db.rollback()
 
# 关闭数据库连接
db.close()
