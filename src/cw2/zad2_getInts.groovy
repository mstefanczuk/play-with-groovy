package cw2

import javax.swing.JOptionPane

// Napisać funkcję List getInts(), która prosi o podanie szeregu liczb całkowitych w dialogu wejściowym i zwraca listę
// wprowadzonych liczb (jako obiektów typu Integer).
// Nie dopuścić do wprowadzenia wadliwych danych (ponowienie dialogu do poprawki).

println getInts("")

def getInts(inputNumbers) {
    def outputNumbers = inputNumbers
    try {
        outputNumbers = JOptionPane.showInputDialog(null,
                "Podaj szereg liczb całkowitych", inputNumbers)
        if (outputNumbers == null) {
            return
        }
        outputNumbers.split('\\s+')
                .each { Integer.valueOf(it) }
    } catch (RuntimeException ignored) {
        return getInts(outputNumbers)
    }
    return outputNumbers
}
