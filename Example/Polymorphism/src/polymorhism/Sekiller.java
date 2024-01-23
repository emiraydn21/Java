package polymorhism;

/**
 *
 * @author Emir AYDIN
 */
class Sekiller {

    //Her şekil Doğru Parçasından oluşur.(Yuvarlak Olanlar Dışında :) )
    //O yüzden oluşturduğumuz Constructor'a dogruParcası ismini vereceğiz.
    void dogruParcası() {
        System.out.println("Doğru Parçası İle Şekiller Hazırlanıyor.");
//        En az 3 doğru parçasının birleşmesinden sonsuz tane şekillerin oluşturulmasıdır.
    }
}

class Daire extends Sekiller {

    void nokta() {
        System.out.println("Daire Oluşturuldu.");
//        Birden Çok noktanın bir araya gelerek eşsiz bir görüntü oluşturmasıdır.
    }
}

class Elips extends Daire {

    void nokta() {
        System.out.println("Elips Oluşturuldu.");
//        Daireye şekil verilerek yumurta şekline benzemesiyle oluşturulur.
    }
}

class Cokgenler extends Sekiller {

    void dogruParcası() {
        System.out.println("Çokgen Oluşturuldu.");
//       Birden çok doğru parçasının bir araya gelmesiyle oluşmuştur.
    }
}

class Ucgen extends Sekiller {

    void dogruParcası() {
        System.out.println("Üçgen Oluşturuldu.");
//       3 eş doğru parçasının bir araya gelmesiyle oluşan çokgenden türetilmiş şekildir.
    }
}

class Kare extends Sekiller {

    void dogruParcası() {
        System.out.println("Kare Oluşturuldu.");
//       4 eş doğru parçasının bir araya gelmesiyle oluşan çokgenden türetilmiş şekildir.
    }
}

class Dikdörtgen extends Sekiller {

    void dogruParcası() {
        System.out.println("Dikdörtgen Oluşturuldu.");
        //2 kısa 2 uzun eş doğru parçasının bir araya gelmesiyle oluşan çokgenden türetilmiş şekildir.
    }
}

class EskenarDörtgen extends Sekiller {

    void dogruParcası() {
        System.out.println("Eşkenar Dörtgen Oluşturuldu.");
        //4 eş doğru parçasının bir araya gelmesiyle oluşan çokgenden türetilmiş şekildir.

    }
}
