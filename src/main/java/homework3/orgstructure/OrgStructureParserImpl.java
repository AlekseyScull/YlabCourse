package homework3.orgstructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class OrgStructureParserImpl implements OrgStructureParser {
    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        List<String> list = new ArrayList<>();
        Map<Long, Employee> employeeMap = new HashMap<>();
        readFileToList(csvFile, list);
        createEmployees(list, employeeMap);
        return setStructureAndGetBoss(employeeMap);
    }

    /**
     * Creates structure from given map of employee and return it's boss
     * @return boss
     */
    private Employee setStructureAndGetBoss(Map<Long, Employee> employeeMap) {
        Employee boss = null;
        for (Long employeeId : employeeMap.keySet()) {
            Employee employee = employeeMap.get(employeeId);
            for (Long subordinateId : employeeMap.keySet()) {
                if (!employeeId.equals(subordinateId)) {
                    Employee subordinate = employeeMap.get(subordinateId);
                    if (subordinate.getBossId() == null) {
                        boss = subordinate;
                    } else if (subordinate.getBossId().equals(employeeId)) {
                        employee.getSubordinate().add(subordinate);
                        subordinate.setBoss(employee);
                    }
                }
            }
        }
        return boss;
    }

    private void readFileToList(File csvFile, List<String> out) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile, StandardCharsets.UTF_8))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                out.add(line);
            }
        }
    }

    private void createEmployees(List<String> stringList, Map<Long, Employee> employeeMap) {
        for (String s : stringList) {
            String[] fields = s.split(";");

            if (fields.length != 4) {
                throw new IllegalArgumentException("bad data");
            }
            Employee employee = new Employee();
            employee.setId(Long.parseLong(fields[0]));
            if (fields[1].equals("")) {
                employee.setBossId(null);
            } else {
                employee.setBossId(Long.parseLong(fields[1]));
            }
            employee.setName(fields[2]);
            employee.setPosition(fields[3]);
            employeeMap.put(employee.getId(), employee);
        }
    }
}
