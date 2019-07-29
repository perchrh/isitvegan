package org.digitalsprouts.estoffer.ui.enumbers

import java.util.Comparator

internal class ENumberComparator : Comparator<String> {
    override fun compare(me: String, other: String): Int {
        try {
            return getEnumberInteger(me).compareTo(getEnumberInteger(other))
        } catch (e: NumberFormatException) {
            return me.compareTo(other)
        }

    }

    private fun getEnumberInteger(me: String): Int {
        var enumberStr = ""

        if (me.length >= 1) {
            val seq = me.subSequence(1, me.length)
            var lastDigit = 0
            while (lastDigit < seq.length && Character.isDigit(seq[lastDigit])) {
                lastDigit++
            }
            enumberStr = seq.subSequence(0, lastDigit).toString()
        }

        return Integer.parseInt(enumberStr)
    }
}
