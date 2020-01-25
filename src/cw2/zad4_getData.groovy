package cw2

import javax.swing.JOptionPane

// Uogólnić funkcję z zadania 2, tak by wprowadzane mogły być dowolne liczby i słowa (napisy rozdzielone białymi znakami),
// a ich poprawność weryfikowana za pomocą przekazanego funkcji domknięcia. Niech funkcja nazywa sie getData.

//println getData(Integer) { it > 0 }
//println getData() { it.size() > 3 }
//println getData()
println getData(BigDecimal)

def getData(param1 = null, param2 = null) {
    while (true) {
        def dialogMessage = "Podaj szereg wartości"
        def values = []

        def input = JOptionPane.showInputDialog(null, dialogMessage, "")
        if (input == null)
            break

        def splittedInputValues = input.split("\\s")

        if (param1 == null) {
            try {
                def toContinue = false
                splittedInputValues.each {
                    it = it as String
                    if (param2 instanceof Closure && !param2(it)) {
                        toContinue = true
                    } else {
                        values.add(it)
                    }
                }
                if (toContinue) {
                    continue
                }
            }
            catch (ignored) {
                continue
            }
        }

        if (param1 instanceof Class) {
            try {
                def toContinue = false
                splittedInputValues.each {
                    it = it.asType(param1)
                    if (param2 instanceof Closure && !param2(it)) {
                        toContinue = true
                    } else {
                        values.add(it)
                    }
                }
                if (toContinue) {
                    continue
                }
            }
            catch (ignored) {
                continue
            }
        }

        if (param1 instanceof Closure) {
            try {
                def toContinue = false
                splittedInputValues.each {
                    it = it as String
                    if (!param1(it)) {
                        toContinue = true
                    } else {
                        values.add(it)
                    }
                }
                if (toContinue) {
                    continue
                }
            }
            catch (ignored) {
                continue
            }
        }

        return values
    }
}
