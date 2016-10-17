import datetime
import random


logname = 'register2.log'

log = open(logname, 'wb')

dt = datetime.datetime.now()

while True:
    register = 'REG:' + str(random.randint(0, 1)) + ", " + str(random.randint(0, 1)) + ", " + str(hex(random.randint(0, 500))) + ", " + "0" + ", " + "0" + ", " + str(hex(random.randint(0, 500))) + "\n"
    # REG:0, 0, 0x780, 1, 1, 0xFF
    log.write(register)

    da = datetime.datetime.now() - dt
    if da.seconds > 30:
        break

log.close()
