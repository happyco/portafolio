import csv
import os, sys
import getpass
import re

### Script configurations begin below this line ###
job = []
filter = []
path = ''
server = ''
port = None

############ End script configurations ############
########### DO NOT EDIT BELOW THIS LINE ###########


def clear(menu=True):
    os.system('cls' if os.name == 'nt' else 'clear')        
    if menu:
        if server and port:
            print "{0:^80}".format("** Server: [%s:%s] **"% (server,port))
        else:
            print "{0:^80}".format("** Server: [None:0000] **")


def inputData(text="Press Enter to continue..."):
    return raw_input(text)


def exitJD():
    clear(False)
    exit()


def selectServer(outside=False):
    clear()
    global server, port
    serverReached = False
    while not serverReached:
        clear()
        print ">>>>>>>>>>>>>> Getting server data (use x to exit)"
        op = inputData("Server [localhost]: ").lower()
        if op in ['']:
            op= "localhost"
        elif op.lower() in ['x']:
            if outside:
                sys.exit()
            else:
                return
        opp = inputData("Port [7654]: ")
        if opp in ['']:
            opp=7654
        elif opp.lower() in ['x']:
            if outside:
                sys.exit()
            else:
                return

        # here calls an internal method to ping the server
        if not True:
            print "Server cannot be reached"
            inputData()
        else:
            serverReached= True
            server = op
            port = opp


def getemail(): #get email list from column D
    with open(path, 'rb') as f:
            result = []
            aux = 1
            reader = csv.reader(f)
            for row in next(reader):
                if aux == 4:#check on column D
                    for mail in row.split(","):
                        result.append(mail.strip())
                    return result
                aux += 1
            return []
        
            
def newdata():#gets the new data structure that is displayed
    with open(path, 'rb') as f:
            result = []
            buffer = []
            aux = 1
            reader = csv.reader(f)
            next(reader)
            next(reader)
            for row in reader:
                for column in row:
                    if aux == 1 or aux == 2:#gets job id and platform
                        buffer.append(column)
                    if aux == len(row):
                        result.append(buffer)
                        buffer = []
                        aux = 0
                    aux += 1
            return result


def getdata():#collects all data for each TC selected that are on variable job
        global job
        with open(path, 'rb') as f:
            reader = csv.reader(f)
            result = []
            for v in job:
                f.seek(0)
                for row in iter(reader):
                        if v[0] == row[0]:
                            result.append(row)
                            
            return result


def getparam():#maps the parameters of the jobs
    param = {}
    with open(path, 'rb') as f:
            reader = csv.reader(f)
            next(reader)
            aux = 0
            for column in next(reader):
                if aux > 3:#after column 3 are the params
                    param[column] = aux-2
                aux += 1
    return param


def varparam():
    vparam = {}
    with open(path, 'rb') as f:
            reader = csv.reader(f)
            next(reader)
            aux = 0
            for column in next(reader):
                if aux > 3:#after column 3 are the params
                    if re.match("^\$", column):
                        vparam[column] = aux-2
                aux += 1
    return vparam


def Run():
    sendjobs = getdata()
    totalbar = len(sendjobs)
    err = []
    progress = 1
    
    if not sendjobs:
        print "There are not jobs to send" 
    else:
        vp = varparam()
        if vp:
            print "\n>>>>>>>>>>>>>> Step 0: Change Variable Parameters"
            print "Variable params: "
            print vp
            varpara={}
            if inputData("Do you want to change the variable params? [N]: ").lower() in ['y', 'yes']:
                for var in vp:
                    print var, ": ",sendjobs[0][int(vp.get(var))+2]
                    if inputData("Do you want to change it? [N]: ").lower() in ['y', 'yes']:
                        varpara[var] = inputData("NEW value: ")
           
        for sj in sendjobs:
            aux = 0
            param = {}
            for row in sj:
                if aux > 2:
                    for f in getparam():
                        if getparam()[f] == aux-2:
                            if re.match("^\$", f):
                                if varpara.get(f):
                                    param[f[1:]] = varpara.get(f)
                                
                                else:
                                    param[f[1:]] = row
                                
                            else:
                                param[f] = row
                                      
                if aux == 2:
                    id = row
                
                if aux == 1:
                    sut = row
                    
                if aux == 0:
                    name=row
                aux += 1

            print id, param, server, name, sut, port, getpass.getuser(), getemail()
            #send the information from above to the server
            os.system('cls' if os.name == 'nt' else 'clear')
            print (progress*100)/totalbar
            progress += 1
        if len(err) > 0:
            print "The are %d jobs that can not be send" % len(err)
            for x in err:
                print x

    inputData()


def Select():
    global job
    global filter
    job = []
    data = False
    value = inputData("Select a job: ")
    aux = 1
    for v in value.split(", "):
        reader = newdata()
        data = False
        for row in reader:
            for column in row:
                if v == column:
                    if filter.count(row) != 0:
                        print "Job already added"
                    else:
                        filter.append(row)
                        data = True
                        print "job %s added" % row
                    data = True
                if aux == len(row):
                    aux = 0
    
                aux += 1
        if not data:
            print "job not found"
     
    job = filter
    if not job:
        job = newdata()
    inputData()


def PrintS():
    global job
    for j in job:
        print j
    inputData()


def Reset():
    global job
    global filter
    filter = []
    job = newdata()


def getfile(outside=False):
    global path
    global job
    global filter
    clear()
    print ">>>>>>>>>>>>>> Step 1: Getting data from CSV"
    cont = 1
    path = os.path.join(os.getcwd(), "files")
    f = []
    for (dirpath, dirnames, filenames) in os.walk(os.path.basename(path)):
        f.extend(filenames)
        break
    print 'Path:',path+"\\"
    for file in f:
        print str(cont)+":",file
        cont += 1
    cont = 1
    print 'x: Exit'
    i = inputData("Choose an option: ")
    if i.lower() in ['x']:
        if outside:
            sys.exit()
        else:
            return
    try:
        for file in f:
            if int(i) == cont:
                path=os.path.join(path, file)
                print "File %s was selected" % file
                getemail()
                job=newdata()
                filter = []
            
            cont += 1
    except ValueError:
        '''
        '''
        print "Option not found."
    if path == (os.path.join(os.getcwd(), "files")):
        print "No file selected"
        inputData()
        getfile()

    
def main(argv):
        global server
        global port
        global job
        selectServer(True)
        getfile(True)  
        clear()           
        menu = {'1': Run, '2': Select, '3': PrintS, '4': Reset, '5': selectServer, '6': getfile, 'x': exitJD}
        while True:
            clear()
            print "[1] Run\n[2] Select jobs\n[3] Print selected jobs\n[4] Reset selected\n[5] Select server\n[6] Changes csv file\n[x] Exit\n"
            i = inputData("Choose an option: ")
            try:
                f = menu.get(i.lower())
                if f:
                    clear()
                    f()
                else:
                    print "Option not found. Select another option"
                    inputData()
            except ValueError:
                print "Option not found. Select another option"
                inputData()
            
if __name__ == "__main__":
    main(sys.argv[1:])
