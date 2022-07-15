package com.wuerthcs.platform.filtering.service

import com.wuerthcs.platform.filtering.domain.FilterOption
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonIdentifierJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionAddonJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionJPAEntity
import com.wuerthcs.platform.filtering.persistence.entity.FilterOptionTranslationJPAEntity
import com.wuerthcs.platform.filtering.persistence.repository.FilteringRepository
import com.wuerthcs.platform.filtering.utils.EntityMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class FilteringInitService(
    private val repository: FilteringRepository,
    private val mapper: EntityMapper
) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun init() {

        val automatisierung = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Automatisierung"
        )

        val vertrieb = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Vertrieb"
        )

        val betriebswerkstatt = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Betriebswerkstatt"
        )

        val galabau = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "GaLa-Bau"
        )

        val autoUndCargo = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Auto und Cargo"
        )

        val einkauf = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Einkauf"
        )

        val buchhaltung = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Buchhaltung"
        )

        val handel = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Handel"
        )

        val finanzen = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Finanzen"
        )

        val lager = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Lager"
        )

        val organisation = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Organisation"
        )

        val inventur = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Inventur"
        )

        val innenausbau = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Innenausbau"
        )

        val auswertungen = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Auswertungen"
        )

        val mobileApp = FilterOptionTranslationJPAEntity(
            language = "de",
            label = "Mobile App"
        )





        val one = FilterOptionAddonIdentifierJPAEntity(
            identifier = "three"
        )

        val two = FilterOptionAddonIdentifierJPAEntity(
            identifier = "two"
        )



        this.repository.saveAndFlush(

            FilterOptionJPAEntity(

                type = 1,
                translation = setOf(de, eng),
                branding = "awkg",
                options = listOf(

                    FilterOptionAddonJPAEntity(

                        id = UUID.fromString("00000000-0000-0000-0000-000000000001"),
                        filterOptionName = setOf(de, eng),
                        addonIdentifier = setOf(one, two),
                        order = 0

                    ),

                    FilterOptionAddonJPAEntity(

                        id = UUID.fromString("00000000-0000-0000-0000-000000000002"),
                        filterOptionName = setOf(de, eng),
                        addonIdentifier = setOf(one, two),
                        order = 0

                    )

                )


            )






        )

    }

}