package homework3.orgstructure;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class OrgStructureParserTest {
    public static void main(String[] args) {
        URL url = OrgStructureParserImpl.class.getResource("/test.csv");
        assert url != null;
        File currFile = new File(url.getFile());
        OrgStructureParser osp = new OrgStructureParserImpl();
        Employee boss;
        try {
            boss = osp.parseStructure(currFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (boss.getBossId() != null) {
                throw new RuntimeException("not boss");

        }
        System.out.println(boss.getId() + " " + boss.getName() + " " + boss.getPosition());
        System.out.println("Subordinates:");
        for (Employee employee : boss.getSubordinate()) {
            System.out.print(employee.getId() + " " + employee.getName() + " " + employee.getPosition());
            if (!employee.getSubordinate().isEmpty()) {
                System.out.print(" Subordinates -> ");
                for (Employee subord : employee.getSubordinate()) {
                    System.out.print(subord.getId() + " " + subord.getName() + " " + subord.getPosition());
                }
            }
            System.out.println();
        }
    }
}
