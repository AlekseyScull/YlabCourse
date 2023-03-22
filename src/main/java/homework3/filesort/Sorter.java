package homework3.filesort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    private long numberOfLines = 1000;

    public File sortFile(File dataFile) {
        List<File> tempFiles = new ArrayList<>();
        File out = new File("sorted_data.txt");
        try {
            readSplitAndSort(dataFile, tempFiles, numberOfLines);
            File file = merge(tempFiles);
            Files.copy(file.toPath(), out.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return out;
    }

    private void readSplitAndSort(File in, List<File> out, long numberOfLines) throws IOException {
        boolean hasNext = true;
        try (BufferedReader br = new BufferedReader(new FileReader(in))) {
            while (hasNext) {
                List<Long> list = new ArrayList<>();
                String line;
                for (int i = 0; i < numberOfLines; i++) {
                    if ((line = br.readLine()) != null) {
                        list.add(Long.parseLong(line));
                    } else {
                        hasNext = false;
                    }
                }
                if (!list.isEmpty()) {
                    Collections.sort(list);
                    out.add(writeSortedBlock(list));
                }
            }
        }
    }

    private File merge(List<File> tempFiles) throws IOException {
        List<File> fileList = new ArrayList<>();
        File result;
        if (tempFiles.size() == 1) {
            fileList.add(tempFiles.get(0));
        } else if (tempFiles.size() > 2) {
            fileList.add(merge(tempFiles.subList(0, tempFiles.size() / 2)));
            fileList.add(merge(tempFiles.subList(tempFiles.size() / 2, tempFiles.size())));
        } else {
            fileList.add(twoWayMerge(tempFiles.get(0), tempFiles.get(1)));
        }
        if (fileList.size() > 1) {
            result = merge(fileList);
        } else {
            result = fileList.get(0);
        }
        return result;
    }

    private File twoWayMerge(File file1, File file2) throws IOException {
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        List<Long> out = new ArrayList<>();
        File merged = Files.createTempFile("merged", null).toFile();
        merged.deleteOnExit();
        boolean hasNext1 = true;
        boolean hasNext2 = true;
        boolean read1 = false;
        boolean read2 = false;
        int i = 0;
        int j = 0;
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
             BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            while (hasNext1 || hasNext2) {
                if (!read1 && hasNext1) {
                    read1 = true;
                    String line;
                    for (int i2 = 0; i2 < numberOfLines / 3; i2++) {
                        if ((line = br1.readLine()) != null) {
                            list1.add(Long.parseLong(line));
                        } else {
                            hasNext1 = false;
                            break;
                        }
                    }
                }
                if (!read2 && hasNext2) {
                    read2 = true;
                    String line;
                    for (int i1 = 0; i1 < numberOfLines / 3; i1++) {
                        if ((line = br2.readLine()) != null) {
                            list2.add(Long.parseLong(line));
                        } else {
                            hasNext2 = false;
                            break;
                        }
                    }
                }
                int m = list1.size();
                int n = list2.size();
                while (i < m && j < n) {
                    if (list1.get(i) <= list2.get(j)) {
                        out.add(list1.get(i++));

                    } else {
                        out.add(list2.get(j++));

                    }
                    if (out.size() == Math.max(m, n)) {
                        appendListToFile(out, merged);
                        out = new ArrayList<>();
                    }
                }
                if (m == 0) {
                    for (; j < list2.size(); j++) {
                        out.add(list2.get(j));
                    }
                    j = n;
                } else if (n == 0) {
                    for (; i < list1.size(); i++) {
                        out.add(list1.get(i));
                    }
                    i = m;
                }
                if (out.size() >= Math.max(m,n)) {
                    appendListToFile(out, merged);
                    out = new ArrayList<>();
                }
                if (i == m) {
                    list1 = new ArrayList<>();
                    read1 = false;
                    i = 0;
                }
                if (j == n) {
                    list2 = new ArrayList<>();
                    read2 = false;
                    j = 0;
                }
            }
        }
        return merged;
    }

    private File writeSortedBlock(List<Long> list) throws IOException {
        File file = Files.createTempFile(null, null).toFile();
        file.deleteOnExit();
        try (FileWriter fw = new FileWriter(file)) {
            for (Long aLong : list) {
                fw.write(aLong + "\n");
            }
            fw.flush();
        }
        return file;
    }

    private void appendListToFile(List<Long> list, File file) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            for (Long aLong : list) {
                fw.write(aLong + "\n");
            }
            fw.flush();
        }
    }
}
