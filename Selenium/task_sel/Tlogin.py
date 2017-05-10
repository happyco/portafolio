from objects.Ologin import Ologin
from objects.Oinbox import Oinbox


def login(user, pswd):
    Ologin().emailtxt().send_keys(user)
    Ologin().nextbutton().click()
    Ologin().pswdtxt().send_keys(pswd)
    Ologin().siginbutton().click()
    Oinbox().inbox()
    return True
