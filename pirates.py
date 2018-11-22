#Isaac Sutor
#11/10/17
#360 Python Pirates Project

global list_of_gems
global gemsSorted
global number
def isValue(item):
    try:
        int(item)
        return True
    except ValueError:
        return False

def types(allValues):
    list_of_types = []
    count = 0
    for thing in allValues:
        for ind in thing:
            if count == 0:
                list_of_types.append(ind)
                count = count + 1
        count = 0
    return list_of_types
    

def numGems(gems):
    count = 0
    for thing in gems:
        for ind in thing:
            count = count + 1
        count = count - 1
    return count

def getMaxGem(gems):
    curMax = 0
    overalMax = 0
    whatGem = 0
    counter = 0
    for thing in gems:
        for ind in thing:
            if isValue(ind):
                if ind > curMax:
                    curMax = ind
                    whatGem = counter
                    #print(curMax)
        if curMax > overalMax:
            overalMax = curMax
            whatGem = counter
        
        counter = counter + 1
    #print(whatGem)
    return [whatGem, overalMax]

def removeGem():
    gemList = types(list_of_gems)
    maxGem = getMaxGem(gemsSorted)
    myGem = ""
    whatGem = maxGem.pop(0)
    print(whatGem)
    myGem = gemList.pop(whatGem)
    print(myGem)
    

def process(after, input):
    list_of_gems = sorted(input, key=lambda x:(-x[1],x[0]))
    gemsSorted = [list(item) for item in list_of_gems]
    
    numOfGems = numGems(gemsSorted)
    numPirates = numOfGems/2
    myNum = numPirates - after
    
    for x in range(1, int(myNum)):
        gemList = types(gemsSorted)
        maxGem = getMaxGem(gemsSorted)
        myGem = maxGem.pop(0)
        
        count = 0
        counter = 0
        for things in gemsSorted:
            for ind in things:
                if count == 1:
                    if myGem == counter:
                        
                        gemsSorted[counter].pop(count)
                        
                        tupleX = ()
                        listX = []
                        listY = []
                        count = 0
                        for things in gemsSorted:
                            for ind in things:
                                count = count + 1
                                listY.append(ind)
                                tuple(listY)
                            if count > 1:
                                listX.append(listY)
                            listY = []
                        list_of_gems = listX
                        list_of_gems = sorted(list_of_gems, key=lambda x:(-x[1],x[0]))
                        gemsSorted = [list(item) for item in list_of_gems]
                count = count + 1
            counter = counter + 1

    gemList = types(gemsSorted)
    maxGem = getMaxGem(gemsSorted)
    myGem = maxGem.pop(0)
    whatGemType = gemList.pop(myGem)
    
    count = 0
    counter = 0
    firstGem = ""
    for things in gemsSorted:
        for ind in things:
            if count == 1:
                if myGem == counter:
                    
                    firstGem = gemsSorted[counter].pop(count)
                    tupleX = ()
                    listX = []
                    listY = []
                    count = 0
                    for things in gemsSorted:
                        for ind in things:
                            count = count + 1
                            listY.append(ind)
                            tuple(listY)
                        if count > 1:
                            listX.append(listY)
                        listY = []
                    list_of_gems = listX
                    list_of_gems = sorted(list_of_gems, key=lambda x:(-x[1],x[0]))
                    gemsSorted = [list(item) for item in list_of_gems]
            count = count + 1
        counter = counter + 1    

    for x in range(0, after*2):
        gemList = types(gemsSorted)
        maxGem = getMaxGem(gemsSorted)
        myGem = maxGem.pop(0)
        count = 0
        counter = 0
        for things in gemsSorted:
            for ind in things:
                if count == 1:
                    if myGem == counter:
                        gemsSorted[counter].pop(count)
                        tupleX = ()
                        listX = []
                        listY = []
                        count = 0
                        for things in gemsSorted:
                            for ind in things:
                                count = count + 1
                                listY.append(ind)
                                tuple(listY)
                            if count > 1:
                                listX.append(listY)
                            listY = []
                        list_of_gems = listX
                        list_of_gems = sorted(list_of_gems, key=lambda x:(-x[1],x[0]))
                        gemsSorted = [list(item) for item in list_of_gems]
                count = count + 1
            counter = counter + 1

    gemList = types(gemsSorted)
    maxGem = getMaxGem(gemsSorted)
    myGem = maxGem.pop(0)
    whatGemType2 = gemList.pop(myGem)
    count = 0
    counter = 0
    secondGem = ""
    for things in gemsSorted:
        for ind in things:
            if count == 1:
                if myGem == counter:
                    secondGem = gemsSorted[counter].pop(count)
                    tupleX = ()
                    listX = []
                    listY = []
                    count = 0
                    for things in gemsSorted:
                        for ind in things:
                            count = count + 1
                            listY.append(ind)
                            tuple(listY)
                        if count > 1:
                            listX.append(listY)
                        listY = []
                    list_of_gems = listX
                    list_of_gems = sorted(list_of_gems, key=lambda x:(-x[1],x[0]))
                    gemsSorted = [list(item) for item in list_of_gems]
            count = count + 1
        counter = counter + 1    



    gemString = whatGemType + ":" + str(firstGem) + " " + whatGemType2 + ":" + str(secondGem)
    return gemString

    

process(1, [('ruby',6000,5000),('diamond',5000,4000)])
process(3, [('Sapphire', 500, 500, 50, 50), ('Ruby',5000,500,50,5), ('Zircon',1,0,0,0), ('Diamond', 10000, 9000, 8000, 6000)])

