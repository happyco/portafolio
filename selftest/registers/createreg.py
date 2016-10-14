import datetime
import random
import time


logname = 'register2.log'

log = open(logname, 'wb')

dt = datetime.datetime.now()

while True:
    register = 'REG:' + str(random.randint(0, 10)) + ", " + str(random.randint(0, 5)) + ", " + str(hex(random.randint(0, 500))) + ", " + str(random.randint(0, 2)) + ", " + str(random.randint(0, 2)) + ", " + str(hex(random.randint(0, 500))) + "\n"
    # REG:0, 0, 0x780, 1, 1, 0xFF
    log.write(register)

    da = datetime.datetime.now() - dt
    if da.seconds > 30:
        break

log.close()
