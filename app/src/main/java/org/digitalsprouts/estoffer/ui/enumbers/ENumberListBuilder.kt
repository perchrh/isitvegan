package org.digitalsprouts.estoffer.ui.enumbers

import android.content.Context

import org.digitalsprouts.estoffer.R

import java.util.ArrayList

import java.util.Arrays.asList

object ENumberListBuilder {

    fun createDetailedList(ctx: Context): List<String> {
        val not_vegan = ctx.resources.getStringArray(R.array.not_vegan)
        val likely_not_vegan = ctx.resources.getStringArray(R.array.likely_not_vegan)
        val maybe_not_vegan = ctx.resources.getStringArray(R.array.maybe_not_vegan)
        val probably = ctx.resources.getStringArray(R.array.likely_vegan_label)
        val highly_likely_vegan = ctx.resources.getStringArray(R.array.highly_likely_vegan)

        val detailedList = ArrayList<String>()

        for (enumber in not_vegan) {
            detailedList.add(enumber + " - " + ctx.getString(R.string.not_vegan_label))
        }
        for (enumber in likely_not_vegan) {
            detailedList.add(enumber + " - " + ctx.getString(R.string.likely_not_vegan_label))
        }
        for (enumber in maybe_not_vegan) {
            detailedList.add(enumber + " - " + ctx.getString(R.string.maybe_not_vegan_label))
        }
        for (enumber in probably) {
            detailedList.add(enumber + " - " + ctx.getString(R.string.likely_vegan_label))
        }
        for (enumber in highly_likely_vegan) {
            detailedList.add(enumber + " - " + ctx.getString(R.string.highly_likely_vegan_label))
        }

        return detailedList
    }

    fun createSimplifiedList(ctx: Context): List<String> {
        val not_vegan = ctx.resources.getStringArray(R.array.not_vegan)
        val likely_not_vegan = ctx.resources.getStringArray(R.array.likely_not_vegan)
        val maybe_not_vegan = ctx.resources.getStringArray(R.array.maybe_not_vegan)
        val probably_vegan = ctx.resources.getStringArray(R.array.likely_vegan_label)

        val list = ArrayList<String>()
        list.addAll(asList(*not_vegan))
        list.addAll(asList(*likely_not_vegan))
        list.addAll(asList(*maybe_not_vegan))
        list.addAll(asList(*probably_vegan))
        //Highly likely vegan intentionally left out

        return list
    }
}
