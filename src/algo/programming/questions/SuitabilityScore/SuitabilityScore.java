/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.programming.questions.SuitabilityScore;




/**
 *
 * @author Tejashree
 */
class SuitabilityScore {

    private java.util.List<Customer> customerList;
    private java.util.List<Item> itemList;
    private java.util.HashSet<String> vowels;

    SuitabilityScore(String file) {
        vowels = new java.util.HashSet<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        customerList = new java.util.ArrayList<Customer>();
        itemList = new java.util.ArrayList<Item>();

        readFile(file);
    }

    void printOutput() {
        if (!customerList.isEmpty()) {

            computeSS();
            double totalSS = 0;
            for (int i = 0; i < customerList.size(); i++) {
                totalSS = totalSS + customerList.get(i).getSuitability();

            }
            System.out.println(totalSS);
        }

    }

    private void computeSS() {
        //For each Product get the customer with highest Suitability
        for (int i = 0; i < itemList.size(); i++) {
            double maxSS = 0;
            Customer maxCustomer = null;
            if (((Item) itemList.get(i)).getNumberOfLetters() % 2 == 0) {
                //even

                for (int k = 0; k < customerList.size(); k++) {

                    if (customerList.get(k).getSuitability() == 0) {
                        double ss = (double) ((Customer) customerList.get(k)).getVowels() * 1.5;
                        // if any common factor exists apart from 1 then multiply the ss by 1.5
                        if (getCommonFactors(
                                ((Item) itemList.get(i)).getNumberOfLetters(),
                                ((Customer) customerList.get(k)).getNumberOfLetters()) > 1) {
                            ss = ss * 1.5;
                        }
                        if (maxSS < ss) {
                            maxSS = ss;

                            maxCustomer = (Customer) customerList.get(k); // gets the Customer with max ss

                        }
                    }

                }

            } else {
                //odd

                for (int k = 0; k < customerList.size(); k++) {

                    if (customerList.get(k).getSuitability() == 0.0) {

                        double ss = (double) ((Customer) customerList.get(k)).getConsonants();

                        // if any common factor exists apart from 1 then multiply the ss by 1.5
                        if (getCommonFactors(
                                ((Item) itemList.get(i)).getNumberOfLetters(),
                                ((Customer) customerList.get(k)).getNumberOfLetters()) > 1) {
                            ss = ss * 1.5;
                        }
                        if (maxSS < ss) {
                            maxSS = ss;

                            maxCustomer = (Customer) customerList.get(k); // gets the Customer with max ss

                        }
                    }

                }

            }
            if (maxCustomer != null) {
                maxCustomer.setSuitability(maxSS);
            }

        }
    }

    double getCommonFactors(int num1, int num2) {

        if (num1 > num2) {
            if (num2 != 0) {
                if (num1 % num2 == 0) {
                    return num2;
                }
                return num1 % num2;
            }
            return num1;
        } else if (num1 != 0) {
            if (num2 % num1 == 0) {
                return num1;
            }
            return num2 % num1;
        }
        return num2;

    }

    private void readFile(String file) {
        try {
            java.io.BufferedReader read = new java.io.BufferedReader(new java.io.FileReader(file));
            String line = null;
            while ((line = read.readLine()) != null) {
                String[] cust_item_line = line.split(";");
                String custs[] = cust_item_line[0].split(",");
                String item[] = cust_item_line[1].split(",");
                //Adding customers into the customers list.
                for (int i = 0; i < custs.length; i++) {
                    customerList.add(new Customer(custs[i].toLowerCase()));
                }

                //Adding items into the items list.
                for (int i = 0; i < item.length; i++) {
                    itemList.add(new Item(item[i].toLowerCase()));
                }

            };
        } catch (java.io.FileNotFoundException ex) {
            
        } catch (java.io.IOException ex) {
        }

    }

    private class Customer {

        String name;
        double suitability = 0.0;
        int totalVowels = -1;
        int totalConsonants = -1;
        int numberOfLetters = -1;

        public int getVowels() {
            if (totalVowels == -1) {   //calculate vowels for the first time.
                totalVowels = 0;
                for (int i = 0; i < name.length(); i++) {
                    if (vowels.contains(String.valueOf(name.toLowerCase().charAt(i)))) {
                        totalVowels++;
                    }
                }

            }
            return totalVowels;
        }

        public int getConsonants() {
            if (totalConsonants == -1) {
                totalConsonants = 0;
                for (int i = 0; i < name.length(); i++) {
                    if (((int) name.toLowerCase().charAt(i)) > 97
                            && ((int) name.toLowerCase().charAt(i)) <= 122
                            && !vowels.contains(String.valueOf(name.toLowerCase().charAt(i)))) {
                        totalConsonants++;
                    }
                }
            }
            return totalConsonants;

        }

        public int getNumberOfLetters() {
            if (numberOfLetters == -1) {
                numberOfLetters = 0;
                for (int i = 0; i < name.length(); i++) {
                    if ((((int) name.charAt(i)) >= 97
                            && ((int) name.charAt(i)) <= 122)
                            || (((int) name.charAt(i)) >= 48
                            && ((int) name.charAt(i)) <= 57)) {

                        numberOfLetters++;
                    }
                }
            }

            return numberOfLetters;
        }

        public String getName() {
            return name;
        }

        public double getSuitability() {
            return suitability;
        }

        public void setSuitability(double suitability) {
            this.suitability = suitability;
        }

        public Customer(String name) {
            this.name = name;

        }

    }

    private class Item {

        String itemName;
        int numberOfLetters = -1;

        public int getNumberOfLetters() {
            if (numberOfLetters == -1) {
                numberOfLetters = 0;
                for (int i = 0; i < itemName.length(); i++) {
                    if ((((int) itemName.charAt(i)) >= 97
                            && ((int) itemName.charAt(i)) <= 122)
                            || (((int) itemName.charAt(i)) >= 48
                            && ((int) itemName.charAt(i)) <= 57)) {

                        numberOfLetters++;
                    }
                }
            }

            return numberOfLetters;
        }

        public Item(String itemName) {
            this.itemName = itemName;
        }

    }

}
