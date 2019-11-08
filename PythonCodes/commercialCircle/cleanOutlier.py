# -*- coding: utf-8 -*-
"""
Created on Thu Nov  7 16:47:15 2019

@author: shehy2
"""

import pymysql
from geopy import distance


class cleanOutlier():
    """
    类的作用:
        清除当前更新数据库距离商圈中心点超出1500米的点,
        到时候进行一二三级商圈归类的时候, 被清除的, 原本应该被归类的点会被重新归类
        目的: 去除那些 因为某些经销点的消失 而不应当存在的点;
        
    创建对象:
        传month参数,只要是数字即可, 如果是1, 会自动转换成String类型的'01'
    """
    
    def __init__(self, month):
        if(int(month)<10):
            self.month = '0'+ str(month)
        elif(int(month)>=10 and int(month) <= 12):
            self.month = str(month)
        else:
            self.month = 'Error'
        
        
    def conndb(self):
        month = self.month
        db = pymysql.connect(host = " ",
                        user =" ",
                        port =  ,
                        password = " ",
                        db = " ")
 
        # 使用cursor()方法获取操作游标 
        cursor = db.cursor()
        # 选择所有商圈的坐标信息(包括 id, lat, lon)
        sql1 = "SELECT id,lat,lon FROM t_dealer_circle WHERE lat != '' AND lon != '' AND lat IS NOT NULL AND lon IS NOT NULL;"
        # 选择已经有标记商圈的点出来
        sql2 = (("SELECT id, lat, lon, dealer_circle_code FROM t_dealer_custom WHERE platform_id IN (1,101) AND created_time <= '2019-%s-30 23:59:59' AND updated_time >= '2019-%s-01 00:00:00' AND dealer_circle_code != '' AND dealer_circle_code IS NOT NULL AND lat != '' AND lon != '' AND lat IS NOT NULL and lon IS NOT NULL AND lat > 0 AND lat < 90 AND lon > 0 AND lon < 180;")%(month,month))
        try:
            cursor.execute(sql1)
            results = cursor.fetchall()
            circleDict = []
            circle_count = 0
            for row in results:
                circleDict.append({
                        'id': int(row[0]),
                        'lat': float(row[1]),
                        'lon': float(row[2])
                        })
                circle_count = circle_count + 1
            
            cursor.execute(sql2)
            rawPointResults = cursor.fetchall()
            rawPointDict = []
            rawPointCount = 0
            for row in rawPointResults:
                try:
                    dCode = int(row[3])
                except:
                    print('经销点归属商圈号转换int类型出错!')
                else:
                    rawPointDict.append({
                            'id': int(row[0]),
                            'lat':float(row[1]),
                            'lon':float(row[2]),
                            'dealerCircleCode':dCode,
                            })
                rawPointCount = rawPointCount + 1
        except:
            print('连接数据库失败')
        
        return (circleDict, rawPointDict)
    
    
    def genCleanSqlQuery(self):
        if (self.month == 'Error'):
            return ('Error')
        else:
            (circleDict, rawPointDict) = self.conndb()
            #print(circleDict)
            #print(rawPointDict)
            for circle in circleDict:
                circle_id = circle['id']
                circle_lat = circle['lat']
                circle_lon = circle['lon']
                for rawPoint in rawPointDict:
                    point_id = rawPoint['id']
                    point_lat = rawPoint['lat']
                    point_lon = rawPoint['lon']
                    dealer_code = rawPoint['dealerCircleCode']
                    if (dealer_code == circle_id):
                        pointA = (circle_lat, circle_lon)
                        pointB = (point_lat, point_lon)
                        d = distance.distance(pointA, pointB).km * 1000
                        if ( d > 1500):
                            #print('发现一个商圈内大于1500米的点!,距离是%0.2f米需要进行清空操作,这个点的id是: %d, 它本归属的商圈号是: %d'%(d,point_id,dealer_code))
                            print('正在写入数据,id:%d, 离商圈: %d 有%0.2f米'%(point_id,circle_id,d))
                            fileName = ('清理%s月大于1500米点数据SQL.txt'%(self.month))
                            with open(fileName, 'a') as fileObj:
                                updateQuery = ("UPDATE t_dealer_custom SET dealer_circle_code = '' WHERE id = '%s' AND platform_id IN (0, 101) AND created_time <= '2019-%s-31 23:59:59' AND updated_time >= '2019-%s-01 00:00:00';\n"%(str(point_id),self.month,self.month))
                                fileObj.write(updateQuery)
            print('写入完成')
            return ('Success')
