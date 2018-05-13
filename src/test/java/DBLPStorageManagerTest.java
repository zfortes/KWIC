package test.java;

import KWIC.DBLPStorageManager;
import KWIC.DataStorageManager;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBLPStorageManagerTest extends DBLPStorageManager {

    @Test
    void init() {
        DataStorageManager data = new DBLPStorageManager();
        data.init("Carro");
        assertNotEquals(data.length(), 0);

    }

    @Test
    void jsonParse() {
        List<String> list = new LinkedList<>();
        list.add("\"@sc\":\"4928\",");
        list.add("\"text\":\"carrier\"");
        list.add("\"info\":{\"authors\":{\"author\":[\"M. Jorge Cardoso\",\"Tal Arbel\",\"Su-Lin Lee\",\"Veronika Cheplygina\",\"Simone Balocco\",\"Diana Mateus\",\"Guillaume Zahnd\",\"Lena Maier-Hein\",\"Stefanie Demirci\",\"Eric Granger\",\"Luc Duong\",\"Marc-André Carbonneau\",\"Shadi Albarqouni\",\"Gustavo Carneiro\"]},\"title\":\"Intravascular Imaging and Computer Assisted Stenting, and Large-Scale Annotation of Biomedical Data and Expert Label Synthesis - 6th Joint International Workshops, CVII-STENT 2017 and Second International Workshop, LABELS 2017, Held in Conjunction with MICCAI 2017, Québec City, QC, Canada, September 10-14, 2017, Proceedings\",\"venue\":[\"CVII-STENT/LABELS@MICCAI\",\"Lecture Notes in Computer Science\"],\"volume\":\"10552\",\"publisher\":\"Springer\",\"year\":\"2017\",\"type\":\"Editorship\",\"key\":\"conf/miccai/2017cvii\",\"doi\":\"10.1007/978-3-319-67534-3\",\"ee\":\"https://doi.org/10.1007/978-3-319-67534-3\",\"url\":\"https://dblp.org/rec/conf/miccai/2017cvii\"},");
        list.add("\"@score\":\"9\",");
        list.add("\"info\":{\"authors\":{\"author\":[\"Carlos M. Domínguez-Matas\",\"Ricardo Carmona-Galán\",\"Francisco J. Sánchez-Fernández\",\"Ángel Rodríguez-Vázquez\"]},\"title\":\"A Focal-Plane Image Processor for Low Power Adaptive Capture and Analysis of the Visual Stimulus.\",\"venue\":\"ISCAS\",\"pages\":\"2690-2693\",\"year\":\"2007\",\"type\":\"Conference and Workshop Papers\",\"key\":\"conf/iscas/Dominguez-MatasCSR07\",\"doi\":\"10.1109/ISCAS.2007.377968\",\"ee\":\"https://doi.org/10.1109/ISCAS.2007.377968\",\"url\":\"https://dblp.org/rec/conf/iscas/Dominguez-MatasCSR07\"},");

        DBLPStorageManager data = new DBLPStorageManager();

        List<String> expected = new LinkedList<>();
        expected.add("Intravascular Imaging and Computer Assisted Stenting, and Large-Scale Annotation of Biomedical Data and Expert Label Synthesis - 6th Joint International Workshops, CVII-STENT 2017 and Second International Workshop, LABELS 2017, Held in Conjunction with MICCAI 2017, Québec City, QC, Canada, September 10-14, 2017, Proceedings");
        expected.add("A Focal-Plane Image Processor for Low Power Adaptive Capture and Analysis of the Visual Stimulus.");

        assertEquals(data.jsonParse(list),  expected);
    }
}