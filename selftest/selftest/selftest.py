import csv
import os
import sys
import re


def delete_row(row):
    if row[14] == "DONT_CARE" or row[16] == "DONT_CARE":
        return True
    
    knowords = ['PCI']
    
    rege = ['CPU']
    
    for word in knowords:
        if row[0] == word:
            return True
        
    for reg in rege:
        if re.search(reg, row[0]):
            return True
        
    knowords = ['xxx']
    
    rege = []
    
    for word in knowords:
        if row[9] == word:
            return True
        
    for reg in rege:
        if re.search(reg, row[9]):
            return True
        
    knowords = ['xxx']
    
    rege = ['y']
    
    for word in knowords:
        if row[10] == word:
            return True
        
    for reg in rege:
        if re.search(reg, row[10]):
            return True
    
    return False


def main():
    try:
        if sys.argv[1] is None:
            print "Set a file as a parameter"
    except IndexError:
        print "Set a file as a parameter"
    else:
        print sys.argv[1]
        if os.path.isfile(sys.argv[1]):
            if str(sys.argv[1]).endswith('.csv'):
                with open(sys.argv[1], 'rb') as f:
                    resultfi = os.path.join(os.path.dirname(sys.argv[1]), 'result.csv')
                    o = open(resultfi, 'wb')
                    buffer = []
                    aux = 1
                    writer = csv.writer(o)
                    reader = csv.reader(f)
                    for row in reader:
                        if not delete_row(row):
                            for column in row:
                                if aux == 3 or aux == 4 or aux == 8 or aux == 9 or aux == 12 or aux == 15 or aux == 17:
                                    aux += 1
                                    continue

                                if aux == len(row):
                                    buffer.append(column)
                                    writer.writerow(buffer)
                                    buffer = []
                                    aux = 0

                                else:
                                    buffer.append(column)

                                aux += 1
                    print "Finish"

            else:
                print "File is not CSV file"

        else:
            print "Invalid directory"


main()