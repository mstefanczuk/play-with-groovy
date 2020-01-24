package cw1

// Napisy wprowadzane w kolejnych dialogach mają formę:  pozycja = koszt.
// Zsumuj wszystkie koszty dla tych samych pozycji (np. mleko, chleb).

map = [:]

while (true) {
    print 'Podaj pozycje i koszt w formie "pozycja = koszt" lub wpisz "suma", żeby zakończyć:\n'
    def line = System.in.newReader().readLine() as String
    if (line == 'suma') {
        map.each { println it.key + " = " + it.value }
        System.exit(0)
    }
    def (product, cost) = line.tokenize(' = ')

    map.put(product, map.get(product) == null ? cost : (map.get(product) as int) + (cost as int))
}
