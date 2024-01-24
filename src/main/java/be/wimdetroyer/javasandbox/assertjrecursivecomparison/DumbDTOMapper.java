package be.wimdetroyer.javasandbox.assertjrecursivecomparison;

public class DumbDTOMapper {


    public Smart toSmart(DumbDTO dumbDTO) {
        var smart = new Smart();
        smart.setSubClass(mapSubClass(dumbDTO.getSubClass()));
        return smart;
    }

    private SmartSubClass mapSubClass(DumbDTOSubClass dumbDTOSubClass) {
        var smartSubClass = new SmartSubClass();
        smartSubClass.setVatNumber(new VatNumber(dumbDTOSubClass.getVatNumber()));
        return smartSubClass;
    }
}
