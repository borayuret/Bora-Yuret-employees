import dto.Input;
import dto.Together;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class EmpWorkHours {

    public static void main(String[] args) throws IOException, ParseException {
        /*
        Input data:
        A CSV file with data in the following format:

        EmpID, ProjectID, DateFrom, DateTo

        Sample data:
        143, 12, 2013-11-01, 2014-01-05
        218, 10, 2012-05-16, NULL
        143, 10, 2009-01-01, 2011-04-27
        */

        // Read Input File
        // File path is passed as parameter
        File file = new File("emp_prj_work_time.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));


        List<Input> inputList = new ArrayList<>();


        String st;

        // Creating an ArrayList from file lines.
        while ((st = br.readLine()) != null)
        {
            String[] data = st.split(",");
            Input input = new Input();
            input.setEmpId(Integer.parseInt(data[0].trim()));
            input.setProjectId(Integer.parseInt(data[1].trim()));
            input.setDateFrom(strToDate(data[2].trim()));

            if (data[3].trim().equals("NULL"))
                input.setDateTo(new Date());
            else
                input.setDateTo(strToDate(data[3].trim()));


            inputList.add(input);
        }

        // Sorting the input list by emp id
        Collections.sort(inputList, Comparator.comparing(Input::getEmpId));


        /*
        Together List:


        Emp1ID, Emp2ID, ProjectID, Days

        Sample data:
        143, 145, 10, 314
        
        */



        Input input1, input2 = null;

        List<Together> togetherList = new ArrayList<>();


        for(int i=0; i<inputList.size()-1; i++){

            for (int j = i+1; j < inputList.size(); j++) {

                input1 = inputList.get(i);
                input2 = inputList.get(j);

                if (input1.getEmpId() != input2.getEmpId() &&
                        input1.getProjectId() == input2.getProjectId())
                {

                    Date startDate = null;

                    if (input1.getDateFrom().after(input2.getDateFrom()))
                        startDate = input1.getDateFrom();
                    else
                        startDate = input2.getDateFrom();

                    Date endDate = null;

                    if (input1.getDateTo().before(input2.getDateTo()))
                        endDate = input1.getDateTo();
                    else
                        endDate = input2.getDateTo();


                    long diff = endDate.getTime() - startDate.getTime();

                    if (diff > 0)
                    {
                        Together together = new Together();
                        together.setEmp1Id(input1.getEmpId());
                        together.setEmp2Id(input2.getEmpId());
                        together.setProjectId(input1.getProjectId());
                        together.setDays((int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));


                        if (togetherList.size() > 0)
                        {
                            for (int k = 0; k < togetherList.size(); k++) {

                                Together temp = togetherList.get(k);

                                if (temp.getEmp1Id() == together.getEmp1Id() && temp.getEmp2Id() == together.getEmp2Id()) {
                                    temp.setDays(temp.getDays() + together.getDays());
                                    break;
                                }
                                else
                                {
                                    togetherList.add(together);
                                    break;
                                }
                            }
                        }
                        else
                            togetherList.add(together);
                    }
                }

            }
        }


        // Sorting the together list by descending days
        Collections.sort(togetherList, Comparator.comparing(Together::getDays).reversed());


        //System.out.println(Arrays.toString(togetherList.toArray()));

        Together topDays = togetherList.get(0);

        System.out.println(topDays.getEmp1Id()+", "+topDays.getEmp2Id()+", "+topDays.getDays());



    }


    public static Date strToDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }

}
