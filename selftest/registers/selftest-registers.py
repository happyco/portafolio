import csv
import os
import sys
import re


def getregisters(number):
    if sys.argv[number] is None:
        print "Set a file as a parameter"
    else:
        print sys.argv[number]
        if os.path.isfile(sys.argv[number]):
            if str(sys.argv[number]).endswith('.log'):
                with open(sys.argv[number], 'rb') as f:
                    cpu = {}
                    for row in f:
                        if re.match('REG:[0-9]+,\s+[0-9]+,\s+0x[0-9a-fA-F]+,\s+[0-9]+,\s+[0-9]+,\s+0x[0-9a-fA-F]+', row):
                            #REG:0, 0, 0x780, 1, 1, 0xFF
                            data = row.replace(' ', '').replace('\r\n', '').split(',')
                            try:
                                if not cpu['CPU'+data[0][11:]]:
                                    cpu.update({'CPU'+data[0][11:]: {'': ''}})
                                    continue
                            except:
                                cpu.update({'CPU'+data[0][11:]: {'': ''}})
                                continue
                            
                            cpu['CPU'+data[0][11:]].update({data[2]: data[5]})

                    f.close()
                    return cpu
    
def main():
    if len(sys.argv) != 3:
        print "missing or too many arguments"
        
    else:
        resultfi = os.path.join(os.path.dirname(sys.argv[1]), 'result.csv')
        reg = os.path.join(os.path.dirname(sys.argv[1]), 'registers.txt')
        o = open(resultfi, 'wb')
        file = open(reg, 'wb')
        writer = csv.writer(o)
        writer.writerow(['CPU', 'Register', 'Value Gold', 'Value Test'])
        doc = [{}, {}]
        for x in range(len(sys.argv)):
            if x > 0:
                doc[x-1] = getregisters(x)

        if len(doc[0]) == len(doc[1]):
            for cpud0 in doc[0]:
                for registers in doc[0][cpud0]:
                    try:
                        if not doc[0][cpud0][registers] == doc[1][cpud0][registers]:
                            writer.writerow([cpud0, registers, doc[0][cpud0][registers], doc[1][cpud0][registers]])
                            
                    except:
                        try:
                            doc[0][cpud0][registers]
                        except:
                            file.write("register %s not in %s file\n" % (registers, os.path.basename(sys.argv[1])))
                            
                        try:
                            doc[1][cpud0][registers]
                        except:
                            file.write("register %s not in %s file\n" % (registers, os.path.basename(sys.argv[2])))
                        
            o.close()
                
        else:
            print "There are different numbers of CPU"
            o.close()
    
main()