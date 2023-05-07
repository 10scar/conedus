import java.util.Random;

import com.github.javafaker.Faker;

public class FakerGenerator {

    public void FakerGenerator(){
        Faker fake = new Faker();
        Random random = new Random(); 
    }

    public static void generador_establecimiento(){
        String[] prestadorPlantaOptions = {"OFICIAL", "PERSONA NATURAL", "FUNDACION O CORPORACIONES", "COMUNIDAD RELIGIOSA",
                "SOCIEDAD", "EDUCACION MISIONAL CONTRATADA", "FEDERACIONES", "COOPERATIVO", "CAJA DE COMPENSACIÓN",
                "CONCESION", "REGIMEN ESPECIAL", "COMUNIDAD", "UNIVERSIDAD"};  
        String[] municipios = {"Bogota", "Medellin", "Cartagena"};
        String municipio_id = municipios[new Random().nextInt(municipios.length)];
        String establecimiento_nombre = faker.company().name();
        String establecimiento_dane = faker.numerify("###########");
        String establecimiento_direccion = faker.address().fullAddress();
        String establecimiento_telefono = faker.phoneNumber().phoneNumber();
        String establecimiento_rector = faker.name().fullName();
        String establecimiento_tipo = getRandomElement(new String[]{"INSTITUCION EDUCATIVA", "CENTRO EDUCATIVO"});
        String establecimiento_etnias = getRandomElement(new String[]{"Ninguna", "Afrocolombiana", "Indígena", "Rom", "Palenquera"});
        String establecimiento_sector = getRandomElement(new String[]{"OFICIAL", "NO OFICIAL"});
        String establecimiento_genero = getRandomElement(new String[]{"MASCULINO", "FEMENINO", "MIXTO"});
        String establecimiento_jornadas = getRandomElement(new String[]{"Mañana", "Tarde", "Noche", "Mañana y tarde", "Tarde y noche", "Jornada continua"});
        String establecimiento_email = faker.internet().emailAddress();
        String establecimiento_calendario = getRandomElement(new String[]{"A", "B"});
        String establecimiento_caracter = getRandomElement(new String[]{"Académico", "Técnico", "Tecnológico", "Académico-Técnico", "Académico-Tecnológico"});
        String establecimiento_licencia = getRandomElement(new String[]{"SIN REVISAR", "CONDICIONAL", "DEFINITIVA", "RECONOCIMIENTO OFICIAL", "REVISADA ACEPTADA", "REVISADA NO ACEPTADA"});
        String establecimiento_modelos = getRandomElement(new String[]{"Educación para el trabajo y el desarrollo humano", "Escuela nueva", "Escuela tradicional", "Escuela activa"});
        String establecimiento_capacidades_excepcionales = getRandomElement(new String[]{"Sí", "No"});
        String establecimiento_discapacidades = getRandomElement(new String[]{"Sí", "No"});
        String discapacidades = faker.lorem().word();
        String idiomas = faker.lorem().word();
        String estado = getRandomElement(new String[]{"NUEVO-ACTIVO", "ANTIGUO-ACTIVO", "CIERRE DEFINITIVO", "CIERRE TEMPORAL"});
        String prestador_servicio = getRandomElement(new String[]{"OFICIAL", "PERSONA NATURAL", "FUNDACION O CORPORACIONES", "COMUNIDAD RELIGIOSA", "SOCIEDAD", "EDUCACION MISIONAL CONTRATADA", "FEDERACIONES", "COOPERATIVO", "CAJA DE COMPENSACIÓN", "CONCESION", "REGIMEN ESPECIAL", "COMUNIDAD", "UNIVERSIDAD"});
        String prestador_planta = prestadorPlantaOptions[random.nextInt(prestadorPlantaOptions.length)];
        String resguardo = fake.address().fullAddress();
        int matricula_contratada = random.nextInt(2);
        boolean internado = fake.bool().bool();
        String coordenadas = "ST_PointFromText('POINT(" + fake.longitude() + " " + fake.latitude() + ")')";

        //"Object establecimiento = new Object();
        //la idea es retornar un objeto de tipo establecimiento. 
    }


    public static void generator_sedes(int establecimiento) {
        // Generar datos aleatorios para cada campo
        String[] municipios = { "Bogota", "Medellin", "Cartagena" };
        String municipio_id = municipios[random.nextInt(municipios.length)];
        int establecimiento_id = establecimiento;
        String sede_dane = faker.regexify("###########");
        String sede_nombre = faker.company().name();
        String sede_zona = random.nextBoolean() ? "URBANA" : "RURAL";
        String sede_direccion = faker.address().fullAddress();
        String sede_telefono = faker.phoneNumber().phoneNumber();
        String sede_email = faker.internet().emailAddress();
        String sede_sector = random.nextBoolean() ? "OFICIAL" : "NO OFICIAL";
        String sede_estado = random.nextBoolean() ? "NUEVO-ACTIVO" : "ANTIGUO-ACTIVO";
        String[] sede_niveles = { "PREESCOLAR", "MEDIA", "BÁSICA SECUNDARIA", "BÁSICA PRIMARIA" };
        String sede_modelos = faker.options().option("Educación para el trabajo y el desarrollo humano",
                "Escuela nueva", "Escuela tradicional", "Escuela activa");
        String[] sede_grados = { "TRANSFORMEMOS", "PROGRAMA PARA JÓVENES EN EXTRAEDAD Y ADULTOS", "UNAD", "A CRECER",
                "ACELERACIÓN DEL APRENDIZAJE", "EDUCACIÓN TRADICIONAL" };
        String coordenadas = String.format("ST_PointFromText('POINT(%s %s)')", faker.address().longitude(),
                faker.address().latitude());

        // Realizar cualquier operación adicional que necesites con los datos generados

        // Retornar true si la generación fue exitosa
        System.out.println("Generación exitosa");
    }

    public static void main(String[] args) {
        
    }
}