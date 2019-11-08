# -*- coding: utf-8 -*-
"""
@Author: shehy2(HenrySHE)

@Date: 2019-10-24 THU
"""
import mysql.connector
import pymysql
import math
import time

class DistanceResult():
    def __init__(self, id1, lat1, lon1):
        self.id1 = id1
        self.lat1 = lat1
        self.lon1 = lon1
        self.id2 = 0
        self.lat2 = 0.0
        self.lon2 = 0.0
        self.distance = -1
    
    def setTwo(self, id2, lat2, lon2, distance):
        self.id2 = id2
        self.lat2 = lat2
        self.lon2 = lon2
        self.distance = distance
    
    def setDistance(self, distance):
        self.distance = distance

    def returnOne(self):
        return (self.id1, self.lat1, self.lon1)

    def returnAll(self):
        return (self.id1, self.lat1, self.lon1, self.id2, self.lat2,self.lon2, self.distance)


class circleObject():
    # c代表circle - 商圈
    def __init__(self,cId, cLat, cLon): 
        self.cId = cId
        self.cLat = cLat
        self.cLon = cLon
        #这里的rawPoints里面, 存的是tuple, 用set的原因是因为可以remove, 到时候越往后, 需要遍历的点越少
        self.rawPoints = set()
        self.cZeroPoints = set()
        self.cOnePoints = set()
        self.cTwoPoints = set()
        self.cThreePoints = set()
        self.cFourPoints = set()
        #用来存储id号, 这些是归属商圈id为空, 但是属于一二三级商圈的点
        self.updateSet = set()
    

def calcDistance2(id1, lat1, lon1, id2, lat2, lon2):
    #地球半径(单位:米)
    R = 6378137
    dlat =  (lat2-lat1) * (math.pi/180)
    dlon =  (lon1-lon2) * (math.pi/180)
    a = math.sin(dlat/2)**2 + math.cos(deg2rad(lat1)) * math.cos(deg2rad(lat2))*math.sin(dlon/2)**2
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
    s = R*c
    return (id2,lat2,lon2,R*c)

def deg2rad(deg):
    return deg*(math.pi/180)

def connDb():
    #获取当前月份数
    month = time.strftime('%m',time.localtime(time.time()))
    month = str(int(time.strftime('%m',time.localtime(time.time())))-1)

    db = pymysql.connect(host = "",
                        user ="",
                        port = ,
                        password = "",
                        db = "")
    
    cursor = db.cursor()
    #选择所有商圈的经纬度,以及id并存储
    sql1 = "SELECT id,lat,lon FROM t_dealer_circle WHERE lat != '' AND lon != '' AND lat IS NOT NULL AND lon IS NOT NULL;"
    #选择所有的还未被归类的数据
    #sql = "SELECT id, dealer_id, lat, lon FROM t_dealer_custom WHERE platform_id IN (0,101) AND created_time <= '2019-09-30 23:59:59' AND updated_time >= '2019-09-01 00:00:00' AND dealer_circle_code = '' AND lat != '' AND lon != ''"
    sql = (("SELECT id, dealer_id, lat, lon FROM t_dealer_custom WHERE platform_id IN (0,101) AND created_time <= '2019-%s-30 23:59:59' AND updated_time >= '2019-%s-01 00:00:00' AND dealer_circle_code = '' AND lat != '' AND lon != '';")%(month,month))
    
    # 选择所有点, 以及它的商圈id (有可能为空'',所以强制转换为str类型)
    #sql2 = "SELECT id, lat, lon,dealer_circle_code FROM t_dealer_custom WHERE platform_id IN (1,101) AND created_time <= '2019-09-30 23:59:59' AND updated_time >= '2019-09-01 00:00:00' AND lat != '' AND lon != '' AND lat IS NOT NULL and lon IS NOT NULL AND lat > 0 AND lat < 90 AND lon > 0 AND lon < 180"
    sql2 = (("SELECT id, lat, lon,dealer_circle_code FROM t_dealer_custom WHERE platform_id IN (1,101) AND created_time <= '2019-%s-30 23:59:59' AND updated_time >= '2019-%s-01 00:00:00' AND lat != '' AND lon != '' AND lat IS NOT NULL and lon IS NOT NULL AND lat > 0 AND lat < 90 AND lon > 0 AND lon < 180;")%(month,month))


    try:
        cursor.execute(sql1)
        results = cursor.fetchall()
        circleDict = []
        newPoints = []
        allPoints = set()
        circle_count = 0
        for row in results:
            circleDict.append({
                'id': int(row[0]),
                'lat': float(row[1]),
                'lon': float(row[2])
            })
            circle_count = circle_count+1
        #print ("id = %s,dealer_circle_code = %s, dealer_circle = %s, lat = %s, lon = %s, province = %s, city = %s" %(id, dealer_circle_code, dealer_circle, lat, lon, province, city))
        #print(circleDict[0]['lat'])
        cursor.execute(sql)
        rawPointResults = cursor.fetchall()
        rawPointCount = 0
        for row in rawPointResults:
            newPoints.append({
                'id': int(row[0]),
                'dealerId': str(row[1]),
                'lat': float(row[2]),
                'lon': float(row[3]),
                "dealerCircleCode":''
            })
            rawPointCount = rawPointCount+1
        
        cursor.execute(sql2)
        allPointResults = cursor.fetchall()
        print('AllPointResults is :%d'%len(allPointResults))
        #allPoints = allPointResults.copy()
        for row in allPointResults:
            try:
                latF = float(row[1])
                lonF = float(row[2])
            except:
                print('强制转换为浮点数的时候出错!')
            else:
                tempVal = (int(row[0]),latF,lonF,str(row[3]))
            #print(tempVal)
            allPoints.add(tempVal)
            # allPoints.append({
            #     'id': int(row[0]),
            #     'lat': row[1],
            #     'lon': row[2],
            #     'dealerCircleCode': str(row[3])
            # })
        
    except:
        print("connDb 连接失败")
    
    cursor.close()
    db.close()
    return circleDict, newPoints, allPoints


def test():
    (a,b,c,d) = calcDistance2(649, 31.175245, 107.513482, 3, 31.17401802, 107.5127163)
    print(a,b,c,d)

#因为数据库无法一次性连接两次(还没看连接池的问题)
def setCircleResults(cObj):
    print('开始连接数据库..')
    #获取同一个商圈的数据:
    db = pymysql.connect(host = "",
                        user ="",
                        port = ,
                        password = "",
                        db = "")

    mycursor = db.cursor()
    # 选择rawPoints (且商圈id和circleObject相匹配的)
    # sql = "SELECT id, lat, lon, dealer_circle_code FROM t_dealer_custom WHERE dealer_circle_code = " + cObj.cId
    # 选择所有点, 以及它的商圈id (有可能为空'',所以强制转换为str类型)
    sql = "SELECT id, lat, lon,dealer_circle_code FROM t_dealer_custom"
    try:
        mycursor.execute(sql)
        results = mycursor.fetchall()
        #新建一个对象
        for row in results:
            resultSet = (int(row[0]),float(row[1]),float(row[2]),str(row[3]))
            #添加所有生点
            cObj.rawPoints.add(resultSet)
        print("setCircleResult 成功")
    except:
        print("Error: 获取商圈数据失败!")
    db.close()

def findOneTwoThreePoints(cObj):
    #第一个商圈计算(1K~1.5K)
    for item in cObj.rawPoints:
        #如果这个点归属商圈的id和当前的商圈id相匹配:
        if item[3] == str(cObj.cId):
            #计算距离,存到tempS
            (tempId,tempLat,tempLon,tempS) = calcDistance2(cObj.cId, cObj.cLat, cObj.cLon, item[0], item[1], item[2])
            #如果在圈内, 且 <=1000 , 直接从rawPoints里面删除, 反正也没什么用
            if (tempS <= 1000.0):
                cObj.cZeroPoints.add((item[0],item[1],item[2],item[3]))
            if (tempS > 1000.0 and tempS <= 1500.0):
                tempResultTuple = (item[0],item[1],item[2],item[3])
                cObj.cOnePoints.add(tempResultTuple)
    #遍历删除掉已经遍历过的点
    for cZeroPoint in cObj.cZeroPoints:
        try:
            cObj.rawPoints.remove(cZeroPoint)
        except:
            print('cZeroPoint移除失败!')
    for cOnePoint in cObj.cOnePoints:
        try:
            cObj.rawPoints.remove(cOnePoint)
        except:
            print('cOnePoint移除失败!')

    #第二个商圈计算, 这次是遍历cObj.cOnePoints, 和 cObj.rawPoints 做遍历 (两层嵌套)
    for itemOne in cObj.cOnePoints:
        for itemTwo in cObj.rawPoints:
            (tempId,tempLat,tempLon,tempS) = calcDistance2(itemOne[0], itemOne[1], itemOne[2], itemTwo[0], itemTwo[1], itemTwo[2])
            #如果这个点在 (0>500)
            if (tempS <= 500.0):
                #添加到第二个圈的数据里
                tempResultTuple = (itemTwo[0], itemTwo[1], itemTwo[2], itemTwo[3])
                cObj.cTwoPoints.add(tempResultTuple)
                if (itemTwo[3] == ''):
                    #如果这个商圈还没被标记, 则把这个点记录到updateSet里面
                    cObj.updateSet.add(itemTwo[0])
    for cTwoPoint in cObj.cTwoPoints:
        try:
            cObj.rawPoints.remove(cTwoPoint)
        except:
            print('cTwoPoint移除失败!')

    #第三个圈计算
    for itemOne in cObj.cTwoPoints:
        for itemTwo in cObj.rawPoints:
            (tempId,tempLat,tempLon,tempS) = calcDistance2(itemOne[0], itemOne[1], itemOne[2], itemTwo[0], itemTwo[1], itemTwo[2])
            #如果这个点在 (0>500)
            if (tempS <= 500.0):
                #添加到第三个圈的数据里
                tempResultTuple = (itemTwo[0], itemTwo[1], itemTwo[2], itemTwo[3])
                cObj.cThreePoints.add(tempResultTuple)
                if (itemTwo[3] == ''):
                    #如果这个商圈还没被标记, 则把这个点记录到updateSet里面
                    cObj.updateSet.add(itemTwo[0])
    for cThreePoint in cObj.cThreePoints:
        try:
            cObj.rawPoints.remove(cThreePoint)
        except:
            print('cThreePoint移除失败!')
    
    #第四个圈计算
    for itemOne in cObj.cThreePoints:
        for itemTwo in cObj.rawPoints:
            (tempId,tempLat,tempLon,tempS) = calcDistance2(itemOne[0], itemOne[1], itemOne[2], itemTwo[0], itemTwo[1], itemTwo[2])
            #如果这个点在 (0>500)
            if (tempS <= 500.0):
                #添加到第四个圈的数据里
                tempResultTuple = (itemTwo[0], itemTwo[1], itemTwo[2], itemTwo[3])
                cObj.cFourPoints.add(tempResultTuple)
                if (itemTwo[3] == ''):
                    #如果这个商圈还没被标记, 则把这个点记录到updateSet里面
                    cObj.updateSet.add(itemTwo[0])
    for cFourPoint in cObj.cFourPoints:
        try:
            cObj.rawPoints.remove(cFourPoint)
        except:
            print('cFourPoint移除失败!')
    '''
    print (cObj.cZeroPoints)
    print ('--------------')
    print (cObj.cOnePoints)
    print ('--------------')
    print (cObj.cTwoPoints)
    print ('--------------')
    print (cObj.cThreePoints)
    print ('--------------')
    print (cObj.cFourPoints)
    '''
    #小的想法, 我是否可以复用这个rawPoints? 这样后面分析的rawPoints会越来越少, 也就是会越来越快
    return cObj.updateSet


#数据库更新操作(已经测试成功, 需要传的是门店点的id(唯一标识),以及需要更改的商圈id号),后续可能改成传一个List会比较好,这样就不用重复连接数据库
def dbUpdate(id,circleNum):
    db = pymysql.connect(host = "",
                        user =,
                        port = ,
                        password = "",
                        db = "")
    
    cursor = db.cursor()
    sql = "UPDATE t_dealer_custom SET dealer_circle_code = "+ circleNum +" WHERE id = " + id
    try:
        cursor.execute(sql)
        db.commit()
        print('数据库更新操作成功!')
    except:
        db.rollback()
        print('更新操作失败! 正在进行回滚')
    db.close()

#查询新增点的归属商圈(逻辑是<=1500米距离的,算属于这个商圈的点,然后进行更新操作)
def findNewPointBelonging(circleDict, newPoints):
    month = str(int(time.strftime('%m',time.localtime(time.time())))-1)
    print('一共发现%d个还未被归如商圈的新增点,现在开始分析..'%(len(newPoints)))
    #开始计算距离
    finalResult = []
    for newPoint in newPoints:
        dist = DistanceResult(newPoint['id'],newPoint['lat'],newPoint['lon'])
        for circle in circleDict:
            #计算距离
            (id1, lat1, lon1) = dist.returnOne()
            (id2,lat2,lon2,sResult) = calcDistance2(id1, lat1, lon1,circle['id'],circle['lat'],circle['lon'])
            if (dist.distance < 0 or sResult< dist.distance):
                dist.setTwo(id2,lat2,lon2,sResult)
            else:
                continue
        #finalResult.append(dist.returnAll())
        (id1F, lat1F,lon1F, id2F, lat2F, lon2F, sF)=dist.returnAll()
        if (sF < 1500.0):
            finalResult.append({
                'id1':id1F,
                'lat1':lat1F,
                'lon1':lon1F,
                'id2':id2F,
                'lat2': lat2F,
                'lon2': lon2F,
                's': sF
            })
    # print(finalResult)
    print('从新增数据中共发现%d条可归入现有商圈的数据'%(len(finalResult)))
    if (len(finalResult) > 0):
        print('正在写入数据到output_filtered.txt')
        filename = 'output_filtered(10月新增点)_SQL.txt'
        with open(filename, 'w') as file_object:
            for item in finalResult:
                #file_object.write(str(item['id1'])+ '\t' + str(item['lat1'])+ '\t' + str(item['lon1'])+ '\t' + str(item['id2'])+ '\t' + str(item['lat2'])+ '\t' + str(item['lon2'])+ '\t' + str(item['s'])+ '\n' )
                updateSqlQuery=  ("UPDATE t_dealer_custom SET dealer_circle_code = '%s' WHERE id = '%s' AND dealer_circle_code = '' AND platform_id IN (0, 101) AND created_time <= '2019-%s-31 23:59:59' AND updated_time >= '2019-%s-01 00:00:00';\n"%(str(item['id2']),str(item['id1']),month,month))
                file_object.write(updateSqlQuery)
        print ('写入完成, 共写入%d条数据'%(len(finalResult)))
        #后续要改成写入数据库

def main():
    #------------------------------------------新点商圈归属计算----------------------------------------------------
    # conn_db_1()
    circleDict, newPoints, allPoints  = connDb()
    print('circleDict Length is %d'%(len(circleDict)))
    print('newPoints Length is %d'%(len(newPoints)))
    print('allPoints Length is %d'%(len(allPoints)))
    findNewPointBelonging(circleDict,newPoints)
    #----------------------------------------商第一二三四个圈计算---------------------------------------------------
    updateTime = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
    print ('商圈点更新时间为: %s'%(updateTime))
    for circle in circleDict:
        #if circle['id'] != 103:
        #    continue
        circleId = circle['id']
        circleLat = circle['lat']
        circleLon = circle['lon']
        print('Circle id: %d, Circle Lat: %f, Circle Lon: %f'%(circleId,circleLat,circleLon))
        
        #创建对象
        cObj = circleObject(circleId,circleLat,circleLon)
        #下面这个函数废弃了
        #setCircleResults(cObj)
        cObj.rawPoints = allPoints.copy()
        #print(cObj.rawPoints.pop())
        resultUpdateSet = findOneTwoThreePoints(cObj)

        #只测试一条
        '''
        print ('商圈id为:%d' %(circleId))
        print('第零圈的点为(0~1000米内):')
        print(cObj.cZeroPoints)
        #print(resultUpdateSet)
        print('第一圈的点为(1000~1500米内):')
        print(cObj.cOnePoints)
        print('第二圈的点为(1500~2000米内):')
        print(cObj.cTwoPoints)
        print('第三圈的点为:(2000~2500米内):')
        print(cObj.cThreePoints)
        print('需要更新的点个数为:')
        print(len(resultUpdateSet))
        print('总共的点的数目:')
        print(len(cObj.cZeroPoints)+len(cObj.cOnePoints)+len(cObj.cTwoPoints)+len(cObj.cThreePoints))
        '''
        if(len(resultUpdateSet) > 0):
            print('正在写入更新数据')
            fileName = '一二三级商圈更新点(10月数据)_SQL.txt'
            with open(fileName, 'a') as fileObj:
                for resultItem in resultUpdateSet:
                    #print(str(circleId))
                    #print(str(resultItem))
                    #print('更新值为 (商圈id)以及(经销点的id)')
                    #resultStr = str(circleId) + '\t' + str(resultItem) + '\t' + updateTime + '\n'
                    #resultStr = str(circleId) + '\t' + str(resultItem)  + '\n'
                    updateSqlQuery=  ("UPDATE t_dealer_custom SET dealer_circle_code = '%s' WHERE id = '%s' AND dealer_circle_code = '' AND platform_id IN (0, 101) AND created_time <= '2019-%s-31 23:59:59' AND updated_time >= '2019-%s-01 00:00:00';\n"%(str(circleId),str(resultItem),'10','10'))
                    print(updateSqlQuery)
                    fileObj.write(updateSqlQuery)
                #fileObj.write(str(resultUpdateSet))
        print('写入完成, 共有%d条新数据待加%d号商圈'%(len(resultUpdateSet),circleId))
        
            

if __name__ == '__main__':
    main()
    