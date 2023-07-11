include { withSpreadSheet; writeSpreadSheet } from './scripts/groogle_sheet.groovy'

str = 'Hello world!'

withSpreadSheet params.sheetId, {
    withSheet params.sheet, {
        str = A2
    }
}

process splitLetters {
  output:
    path 'chunk_*'

  """
  printf '${str}' | split -b 6 - chunk_
  """
}

process convertToUpper {
  input:
    path x
  output:
    stdout

  """
  cat $x | tr '[a-z]' '[A-Z]'
  """
}


workflow {
  splitLetters | flatten | convertToUpper | view { writeSpreadSheet(params.sheetId, params.sheet, it.trim()) }
}
