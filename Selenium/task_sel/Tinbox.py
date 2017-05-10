from objects.Oinbox import Oinbox
from objects.Ologin import Ologin


def logout():
    Oinbox().inbox()
    Oinbox().account_info().click()
    Oinbox().logout().click()
    Ologin().pswdtxt()
    return True