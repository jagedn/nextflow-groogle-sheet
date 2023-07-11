@Grab(group = 'com.puravida-software.groogle', module = 'groogle-sheet', version = '3.0.0')
@GrabExclude(group = 'org.codehaus.groovy', module = '*')

import com.puravida.groogle.*
import com.google.api.services.sheets.v4.SheetsScopes


def withSpreadSheet(String id, Closure closure) {
    def groogle = GroogleBuilder.build {
        withServiceCredentials {
            withScopes SheetsScopes.SPREADSHEETS
        }
        service SheetServiceBuilder.build(), SheetService
    }
    def sheetService = groogle.service(SheetService) as SheetService

    sheetService.withSpreadSheet id, closure
}

def writeSpreadSheet(String id, String tab, x) {
    def groogle = GroogleBuilder.build {
        withServiceCredentials {
            withScopes SheetsScopes.SPREADSHEETS
        }
        service SheetServiceBuilder.build(), SheetService
    }
    def sheetService = groogle.service(SheetService) as SheetService

    sheetService.withSpreadSheet id, {
        withSheet tab, {
            append "B3", "C3", {
                insert x, new Date().toString()
            }
        }
    }
    x
}