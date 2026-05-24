-- Northwind products lentelė

-- 1. Išveskite visus produktus iš lentelės Products.

-- 2. Išveskite produktus, kurių kaina (UnitPrice) didesnė nei 50.

-- 3. Išveskite produktus, kurie yra nebeparduodami (Discontinued).

-- 4. Išveskite produktus, kurių pavadinime yra žodis "dried".

-- 5. Išveskite produktus, kurie yra nebegaminami (Discontinued) bet dar yra pardavime (in stock).

-- 6. Išveskite produktus, kurių kaina yra tarp 20 ir 40.

-- 7. Išveskite produktus, kurie yra arba neparduodami, arba jų kaina mažesnė nei 10.

-- 8. Išveskite visus produktus, kurių kategorijos ID yra 1, 2 arba 3 (naudojant IN).

-- 9. Išveskite produktus, kurie neturi nurodyto (NULL) tiekėjo (tokių nėra, todėl 0 rezultatų).

-- 10. Išveskite 5 brangiausius produktus pagal UnitPrice.

-- 11. Išveskite mažiausią ir didžiausią produkto kainą.

-- 12. Suskaičiuokite, kiek yra neparduodamų produktų.

-- 13. Išveskite vidutinę produkto kainą tarp visų produktų.

-- 14. Suskaičiuokite, kiek yra produktų kiekvienoje kategorijoje.

-- 15. Išveskite kategorijas, kuriose yra daugiau nei 10 produktų.

-- 16. Išveskite kategorijas, kurių vidutinė produkto kaina didesnė nei 30.

-- 17. Išveskite tiekėjus (SupplierID), kurių produktų kiekis sandėlyje viršija 200 vnt. (bendras kiekis per visus jų produktus).

-- 18. Išveskite produktus, kurie yra pigesni nei vidutinė visų produktų kaina.

-- 19. Išveskite brangiausio produkto kainą kiekvienoje kategorijoje (naudojant GROUP BY ir MAX).

-- 20. Išveskite produktus, kurių tiekimo kiekis (UnitsOnOrder) yra didžiausias.

-- 21. Išveskite produktus, kurių sandėlyje yra mažiau nei užsakytų vienetų (unitsinstock < unitsonorder).

-- 22. Išveskite kategorijos ID, kuriai priklauso daugiausiai produktų.

-- 23. Išveskite tiekėjų ID, kurie tiekia tik produktus, kurių kaina mažesnė nei visų produktų vidutinė kaina.

-- 24. Išveskite 5 tiekėjus, kurių produktų kainų vidurkis yra aukščiausias, tačiau rodykite tik tiekėjus,
--     kurių visi produktai yra aktyvūs (discontinued = 'n') ir kurie tiekia bent 3 produktus.

-- 25. Įterpkite naują produktą pavadinimu "Organic Honey", kainuojantį 15.50, kuris priklauso kategorijai 2,
--     turi 100 vnt. sandėlyje, 20 vnt. užsakyta ir tiekėją su ID 5.

-- 26. Atlikite kainos pakeitimą visiems produktams, kurių tiekėjas yra 3 – padidinkite kainą 10%.

-- 27. Nustatykite, kad visi produktai, kurių sandėlio likutis yra 0, būtų pažymėti kaip discontinued.

-- 28. Pašalinkite visus produktus, kurių kaina yra mažesnė nei 1 ir jie neturi sandėlio likučio bei nėra užsakyti. 

-- 29. Įterpkite 3 naujus testinius produktus  su skirtingomis kategorijomis ir kainomis,
--     kurie būtų naudojami testavimui (žodis Test pavadinime), ir pažymėkite juos kaip neparduodamus.

-- 30. Pašalinkite visus produktus, kurių pavadinime yra žodis "Test".



