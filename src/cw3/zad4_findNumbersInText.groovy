package cw3

import groovy.json.JsonSlurper

// a) Napisać wyrażenie regularne, za pomoca którego mozna odnaleźć w tekście dowolne liczby rzeczywiste.
// b) zastosować je do przetwarzania tekstu zawierającego (posród innych) napisy w postaci liczba PLN,
//    w taki sposób, aby zamienić te fragmenty na liczba EUR (po aktualnym kursie)

File file = new File('./zad4_findNumbersInText_input.txt')

def stringBuffer = new StringBuffer()
file.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        stringBuffer << line
    }
}

def plnAmounts = findPlnAmounts(stringBuffer)

printPlnAmounts(plnAmounts)
replacePlnAmountsWithEurAmountsInFile(plnAmounts, stringBuffer.toString())

def printPlnAmounts(amounts) {
    println 'Lista kwot w PLN:'
    amounts.each { it ->
        println it + " PLN"
    }
}

def replacePlnAmountsWithEurAmountsInFile(List plnAmountsList, String inputText) {
    println "Przeliczanie kwot i zapis do pliku wyjsciowego"

    def connection = new URL('https://api.exchangeratesapi.io/latest?base=PLN&symbols=EUR')
            .openConnection() as HttpURLConnection

    if (connection.responseCode == 200) {
        def json = connection.inputStream.withCloseable { inputStream ->
            new JsonSlurper().parse(inputStream as InputStream)
        }

        def rate = json.rates['EUR']
        def outputText = inputText
        plnAmountsList.each { it ->
            def eurAmount = it.multiply(rate).round(2)
            println "${it} PLN zmieniono na ${eurAmount} EUR"
            outputText = outputText.replace("${it} PLN", "${eurAmount} EUR")
        }
        new File("./zad4_findNumbersInText_output.txt").append(outputText)
    } else {
        println "Problem z połączeniem do API z walutami"
    }
}

def findPlnAmounts(stringBufferInput) {
    def plnAmounts = []
    stringBufferInput.toString()
            .findAll('[+-]?\\d+(\\.\\d+)? PLN')
            .each { date ->
                splitted = date.split(' ')
                plnAmounts.add(new BigDecimal(splitted[0]))
            }

    return plnAmounts
}
