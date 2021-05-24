package Interface;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Utility.*;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;


public class Hospital extends javax.swing.JFrame {

    private JFrame goBack;

    /**
     *
     * Arrays to store all labels for later code reuse
     *
     */
    private JLabel[] patientsReception = new JLabel[22];
    private JLabel[] patientsImageReception = new JLabel[22];
    private JLabel[] patientsVaccination = new JLabel[10];
    private JLabel[] patientsImageVaccination = new JLabel[10];
    private JLabel[] healthcaresVaccination = new JLabel[10];
    private JLabel[] healthcaresImageVaccination = new JLabel[10];
    private JLabel[] patientsObservation = new JLabel[20];
    private JLabel[] patientsImageObservation = new JLabel[20];
    private JLabel[] healthcaresObservation = new JLabel[20];
    private JLabel[] healthcaresImageObservation = new JLabel[20];
    private JLabel[] healthcaresRest = new JLabel[10];
    private JLabel[] healthcaresImageRest = new JLabel[10];
    private JLabel[] auxiliariesRest = new JLabel[2];
    private JLabel[] auxiliariesImageRest = new JLabel[2];
    public JButton[] buttonDesks = new JButton[10];

    /**
     *
     * Images used
     *
     */
    private final ImageIcon patientImage = generateImage(".\\src\\main\\java\\IconImages\\patient.png", 25, 25);
    private final ImageIcon healthcareImage = generateImage(".\\src\\main\\java\\IconImages\\healthcareworker.png", 25, 25);
    private final ImageIcon auxiliaryImage = generateImage(".\\src\\main\\java\\IconImages\\auxiliaryworker.png", 25, 25);
    private final ImageIcon receptionCounterOpenImage = generateImage(".\\src\\main\\java\\IconImages\\receptionboothopen.png", 40, 80);
    private final ImageIcon receptionCounterCloseImage = generateImage(".\\src\\main\\java\\IconImages\\receptionboothclose.png", 40, 80);
    private final ImageIcon vaccinationCounterOpenImage = generateImage(".\\src\\main\\java\\IconImages\\vaccinationboothopen.png", 60, 95);
    private final ImageIcon vaccinationCounterCloseImage = generateImage(".\\src\\main\\java\\IconImages\\vaccinationboothclose.png", 60, 95);
    private final ImageIcon vaccinesContainer0Image = generateImage(".\\src\\main\\java\\IconImages\\vaccinecontainer0.png", 60, 50);
    private final ImageIcon vaccinesContainer1Image = generateImage(".\\src\\main\\java\\IconImages\\vaccinecontainer1.png", 60, 50);
    private final ImageIcon vaccinesContainer2Image = generateImage(".\\src\\main\\java\\IconImages\\vaccinecontainer2.png", 60, 50);
    private final ImageIcon vaccinesContainer3Image = generateImage(".\\src\\main\\java\\IconImages\\vaccinecontainer3.png", 60, 50);
    private final ImageIcon deskOpenImage = generateImage(".\\src\\main\\java\\IconImages\\opendesk.png", 35, 35);
    private final ImageIcon deskCloseImage = generateImage(".\\src\\main\\java\\IconImages\\closedesk.png", 35, 35);

    /**
     *
     * Hues used
     *
     */
    private final Color greyBackground = new Color(191, 191, 191);
    private final java.awt.Color greyBorderColor = new java.awt.Color(127, 127, 127);
    private final Color patientBackground = new Color(250, 234, 221);
    private final java.awt.Color patientBorderColor = new java.awt.Color(233, 151, 87);
    private final Color healthcareBackground = new Color(239, 214, 218);
    private final java.awt.Color healthcareBorderColor = new java.awt.Color(165, 63, 82);
    private final Color auxiliaryBackground = new Color(208, 211, 222);
    private final java.awt.Color auxiliaryBorderColor = new java.awt.Color(68, 84, 106);

    /**
     *
     * Borders used
     *
     */
    private final javax.swing.border.LineBorder greyBorder = new javax.swing.border.LineBorder(greyBorderColor, 2, true);
    private final javax.swing.border.LineBorder patientBorder = new javax.swing.border.LineBorder(patientBorderColor, 2, true);
    private final javax.swing.border.LineBorder healthcareBorder = new javax.swing.border.LineBorder(healthcareBorderColor, 2, true);
    private final javax.swing.border.LineBorder auxiliaryBorder = new javax.swing.border.LineBorder(auxiliaryBorderColor, 2, true);

    /**
     * Creates new form Hospital
     *
     * @param v: previous frame
     *
     */
    public Hospital(JFrame v) {
        initComponents();
        goBack = v;
        goBack.setVisible(false);
        this.setVisible(true);
        initArrays();
    }

    /**
     * Generates images for labels to display
     *
     * @param path: where image is located
     * @param x: horizontal size in pixels
     * @param y: vertical size in pixels
     * @return img: image in corresponding format to display in labels
     *
     */
    public ImageIcon generateImage(String path, int x, int y) {
        ImageIcon img = new javax.swing.ImageIcon(path);
        Image image = img.getImage(); // transform it 
        Image newimg = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        img = new ImageIcon(newimg);  // transform it back

        return img;
    }

    /**
     *
     * Add all labels to arrays
     *
     */
    public void initArrays() {
        patientsReception[0] = patientReception1;
        patientsReception[1] = patientReception2;
        patientsReception[2] = patientReception3;
        patientsReception[3] = patientReception4;
        patientsReception[4] = patientReception5;
        patientsReception[5] = patientReception6;
        patientsReception[6] = patientReception7;
        patientsReception[7] = patientReception8;
        patientsReception[8] = patientReception9;
        patientsReception[9] = patientReception10;
        patientsReception[10] = patientReception11;
        patientsReception[11] = patientReception12;
        patientsReception[12] = patientReception13;
        patientsReception[13] = patientReception14;
        patientsReception[14] = patientReception15;
        patientsReception[15] = patientReception16;
        patientsReception[16] = patientReception17;
        patientsReception[17] = patientReception18;
        patientsReception[18] = patientReception19;
        patientsReception[19] = patientReception20;
        patientsReception[20] = patientReception21;
        patientsReception[21] = patientReception22;

        patientsImageReception[0] = patientImageReception1;
        patientsImageReception[1] = patientImageReception2;
        patientsImageReception[2] = patientImageReception3;
        patientsImageReception[3] = patientImageReception4;
        patientsImageReception[4] = patientImageReception5;
        patientsImageReception[5] = patientImageReception6;
        patientsImageReception[6] = patientImageReception7;
        patientsImageReception[7] = patientImageReception8;
        patientsImageReception[8] = patientImageReception9;
        patientsImageReception[9] = patientImageReception10;
        patientsImageReception[10] = patientImageReception11;
        patientsImageReception[11] = patientImageReception12;
        patientsImageReception[12] = patientImageReception13;
        patientsImageReception[13] = patientImageReception14;
        patientsImageReception[14] = patientImageReception15;
        patientsImageReception[15] = patientImageReception16;
        patientsImageReception[16] = patientImageReception17;
        patientsImageReception[17] = patientImageReception18;
        patientsImageReception[18] = patientImageReception19;
        patientsImageReception[19] = patientImageReception20;
        patientsImageReception[20] = patientImageReception21;
        patientsImageReception[21] = patientImageReception22;

        patientsVaccination[0] = patientVaccination1;
        patientsVaccination[1] = patientVaccination2;
        patientsVaccination[2] = patientVaccination3;
        patientsVaccination[3] = patientVaccination4;
        patientsVaccination[4] = patientVaccination5;
        patientsVaccination[5] = patientVaccination6;
        patientsVaccination[6] = patientVaccination7;
        patientsVaccination[7] = patientVaccination8;
        patientsVaccination[8] = patientVaccination9;
        patientsVaccination[9] = patientVaccination10;

        patientsImageVaccination[0] = patientImageVaccination1;
        patientsImageVaccination[1] = patientImageVaccination2;
        patientsImageVaccination[2] = patientImageVaccination3;
        patientsImageVaccination[3] = patientImageVaccination4;
        patientsImageVaccination[4] = patientImageVaccination5;
        patientsImageVaccination[5] = patientImageVaccination6;
        patientsImageVaccination[6] = patientImageVaccination7;
        patientsImageVaccination[7] = patientImageVaccination8;
        patientsImageVaccination[8] = patientImageVaccination9;
        patientsImageVaccination[9] = patientImageVaccination10;

        healthcaresVaccination[0] = healthcareVaccination1;
        healthcaresVaccination[1] = healthcareVaccination2;
        healthcaresVaccination[2] = healthcareVaccination3;
        healthcaresVaccination[3] = healthcareVaccination4;
        healthcaresVaccination[4] = healthcareVaccination5;
        healthcaresVaccination[5] = healthcareVaccination6;
        healthcaresVaccination[6] = healthcareVaccination7;
        healthcaresVaccination[7] = healthcareVaccination8;
        healthcaresVaccination[8] = healthcareVaccination9;
        healthcaresVaccination[9] = healthcareVaccination10;

        healthcaresImageVaccination[0] = healthcareImageVaccination1;
        healthcaresImageVaccination[1] = healthcareImageVaccination2;
        healthcaresImageVaccination[2] = healthcareImageVaccination3;
        healthcaresImageVaccination[3] = healthcareImageVaccination4;
        healthcaresImageVaccination[4] = healthcareImageVaccination5;
        healthcaresImageVaccination[5] = healthcareImageVaccination6;
        healthcaresImageVaccination[6] = healthcareImageVaccination7;
        healthcaresImageVaccination[7] = healthcareImageVaccination8;
        healthcaresImageVaccination[8] = healthcareImageVaccination9;
        healthcaresImageVaccination[9] = healthcareImageVaccination10;

        patientsObservation[0] = patientObservation1;
        patientsObservation[1] = patientObservation2;
        patientsObservation[2] = patientObservation3;
        patientsObservation[3] = patientObservation4;
        patientsObservation[4] = patientObservation5;
        patientsObservation[5] = patientObservation6;
        patientsObservation[6] = patientObservation7;
        patientsObservation[7] = patientObservation8;
        patientsObservation[8] = patientObservation9;
        patientsObservation[9] = patientObservation10;
        patientsObservation[10] = patientObservation11;
        patientsObservation[11] = patientObservation12;
        patientsObservation[12] = patientObservation13;
        patientsObservation[13] = patientObservation14;
        patientsObservation[14] = patientObservation15;
        patientsObservation[15] = patientObservation16;
        patientsObservation[16] = patientObservation17;
        patientsObservation[17] = patientObservation18;
        patientsObservation[18] = patientObservation19;
        patientsObservation[19] = patientObservation20;

        patientsImageObservation[0] = patientImageObservation1;
        patientsImageObservation[1] = patientImageObservation2;
        patientsImageObservation[2] = patientImageObservation3;
        patientsImageObservation[3] = patientImageObservation4;
        patientsImageObservation[4] = patientImageObservation5;
        patientsImageObservation[5] = patientImageObservation6;
        patientsImageObservation[6] = patientImageObservation7;
        patientsImageObservation[7] = patientImageObservation8;
        patientsImageObservation[8] = patientImageObservation9;
        patientsImageObservation[9] = patientImageObservation10;
        patientsImageObservation[10] = patientImageObservation11;
        patientsImageObservation[11] = patientImageObservation12;
        patientsImageObservation[12] = patientImageObservation13;
        patientsImageObservation[13] = patientImageObservation14;
        patientsImageObservation[14] = patientImageObservation15;
        patientsImageObservation[15] = patientImageObservation16;
        patientsImageObservation[16] = patientImageObservation17;
        patientsImageObservation[17] = patientImageObservation18;
        patientsImageObservation[18] = patientImageObservation19;
        patientsImageObservation[19] = patientImageObservation20;

        healthcaresObservation[0] = healthcareObservation1;
        healthcaresObservation[1] = healthcareObservation2;
        healthcaresObservation[2] = healthcareObservation3;
        healthcaresObservation[3] = healthcareObservation4;
        healthcaresObservation[4] = healthcareObservation5;
        healthcaresObservation[5] = healthcareObservation6;
        healthcaresObservation[6] = healthcareObservation7;
        healthcaresObservation[7] = healthcareObservation8;
        healthcaresObservation[8] = healthcareObservation9;
        healthcaresObservation[9] = healthcareObservation10;
        healthcaresObservation[10] = healthcareObservation11;
        healthcaresObservation[11] = healthcareObservation12;
        healthcaresObservation[12] = healthcareObservation13;
        healthcaresObservation[13] = healthcareObservation14;
        healthcaresObservation[14] = healthcareObservation15;
        healthcaresObservation[15] = healthcareObservation16;
        healthcaresObservation[16] = healthcareObservation17;
        healthcaresObservation[17] = healthcareObservation18;
        healthcaresObservation[18] = healthcareObservation19;
        healthcaresObservation[19] = healthcareObservation20;

        healthcaresImageObservation[0] = healthcareImageObservation1;
        healthcaresImageObservation[1] = healthcareImageObservation2;
        healthcaresImageObservation[2] = healthcareImageObservation3;
        healthcaresImageObservation[3] = healthcareImageObservation4;
        healthcaresImageObservation[4] = healthcareImageObservation5;
        healthcaresImageObservation[5] = healthcareImageObservation6;
        healthcaresImageObservation[6] = healthcareImageObservation7;
        healthcaresImageObservation[7] = healthcareImageObservation8;
        healthcaresImageObservation[8] = healthcareImageObservation9;
        healthcaresImageObservation[9] = healthcareImageObservation10;
        healthcaresImageObservation[10] = healthcareImageObservation11;
        healthcaresImageObservation[11] = healthcareImageObservation12;
        healthcaresImageObservation[12] = healthcareImageObservation13;
        healthcaresImageObservation[13] = healthcareImageObservation14;
        healthcaresImageObservation[14] = healthcareImageObservation15;
        healthcaresImageObservation[15] = healthcareImageObservation16;
        healthcaresImageObservation[16] = healthcareImageObservation17;
        healthcaresImageObservation[17] = healthcareImageObservation18;
        healthcaresImageObservation[18] = healthcareImageObservation19;
        healthcaresImageObservation[19] = healthcareImageObservation20;

        healthcaresRest[0] = healthcareRest1;
        healthcaresRest[1] = healthcareRest2;
        healthcaresRest[2] = healthcareRest3;
        healthcaresRest[3] = healthcareRest4;
        healthcaresRest[4] = healthcareRest5;
        healthcaresRest[5] = healthcareRest6;
        healthcaresRest[6] = healthcareRest7;
        healthcaresRest[7] = healthcareRest8;
        healthcaresRest[8] = healthcareRest9;
        healthcaresRest[9] = healthcareRest10;

        healthcaresImageRest[0] = healthcareImageRest1;
        healthcaresImageRest[1] = healthcareImageRest2;
        healthcaresImageRest[2] = healthcareImageRest3;
        healthcaresImageRest[3] = healthcareImageRest4;
        healthcaresImageRest[4] = healthcareImageRest5;
        healthcaresImageRest[5] = healthcareImageRest6;
        healthcaresImageRest[6] = healthcareImageRest7;
        healthcaresImageRest[7] = healthcareImageRest8;
        healthcaresImageRest[8] = healthcareImageRest9;
        healthcaresImageRest[9] = healthcareImageRest10;

        auxiliariesRest[0] = auxiliaryRest1;
        auxiliariesRest[1] = auxiliaryRest2;

        auxiliariesImageRest[0] = auxiliaryImageRest1;
        auxiliariesImageRest[1] = auxiliaryImageRest2;

        buttonDesks[0] = buttonDesk1;
        buttonDesks[1] = buttonDesk2;
        buttonDesks[2] = buttonDesk3;
        buttonDesks[3] = buttonDesk4;
        buttonDesks[4] = buttonDesk5;
        buttonDesks[5] = buttonDesk6;
        buttonDesks[6] = buttonDesk7;
        buttonDesks[7] = buttonDesk8;
        buttonDesks[8] = buttonDesk9;
        buttonDesks[9] = buttonDesk10;
    }

   
    /**
     *
     * Changes labels display when desk is activated or deactivated
     *
     * @param pos: position of the desk
     * @param open: icon displayed at the moment
     *
     */
    public void buttonDesksStyleChange(int pos, boolean open) {
        Color newHealthcareBackground;
        javax.swing.border.LineBorder newHealthcareBorder;
        Color newPatientBackground;
        javax.swing.border.LineBorder newPatientBorder;
        if (open) {

            buttonDesks[pos].setIcon(deskCloseImage);
            newHealthcareBackground = healthcareBackground;
            newHealthcareBorder = healthcareBorder;
            newPatientBackground = patientBackground;
            newPatientBorder = patientBorder;

        } else {

            buttonDesks[pos].setIcon(deskOpenImage);
            newHealthcareBackground = greyBackground;
            newHealthcareBorder = greyBorder;
            newPatientBackground = greyBackground;
            newPatientBorder = greyBorder;

        }
        healthcaresImageVaccination[pos].setIcon(null);
        healthcaresImageVaccination[pos].setBackground(newHealthcareBackground);
        healthcaresImageVaccination[pos].setBorder(newHealthcareBorder);
        healthcaresVaccination[pos].setText("");
        healthcaresVaccination[pos].setBackground(newHealthcareBackground);
        healthcaresVaccination[pos].setBorder(newHealthcareBorder);
        patientsImageVaccination[pos].setIcon(null);
        patientsImageVaccination[pos].setBackground(newPatientBackground);
        patientsImageVaccination[pos].setBorder(newPatientBorder);
        patientsVaccination[pos].setText("");
        patientsVaccination[pos].setBackground(newPatientBackground);
        patientsVaccination[pos].setBorder(newPatientBorder);

    }

    /**
     *
     * Action performed by all desk buttons
     *
     * @param pos: position of the desk
     *
     */
    public void buttonDesksActionPerfomed(int pos) {
        if (buttonDesks[pos].getIcon() == deskCloseImage) {
            buttonDesksStyleChange(pos, false);

        } else {
            buttonDesksStyleChange(pos, true);
        }
    }

    /**
     *
     * Display patients waiting in reception to be attended
     *
     * @param patientsWaiting
     *
     */
    public void displayPatientsQueueReception(Queue patientsWaiting) {
        int i = 0;
        Patient patient;
        Iterator<Integer> itr = patientsWaiting.iterator();
        while (itr.hasNext() && i < 23) {
            patient = (Patient) itr;
            patientsReception[i].setText(patient.getID());
            patientsImageReception[i].setIcon(patientImage);
            if (i == 22) {
                patientsReception[i].setText("...");
                patientsImageReception[i].setIcon(null);
            }
            i++;
        }
        while (i < 23) {
            patientsReception[i].setText("");
            patientsImageReception[i].setIcon(null);
            i++;
        }
    }

    /**
     *
     * Display the auxiliary working or not
     *
     * @param receptionistStatus: if 2 means they are resting
     *
     */
    public void displayReceptionistBooth(int receptionistStatus) {
        if (receptionistStatus == 2) {
            receptionCounter.setIcon(receptionCounterCloseImage);
        } else {
            receptionCounter.setIcon(receptionCounterOpenImage);
        }
    }

    /**
     *
     * Display patient being checked in the moment
     *
     * @param patientAtFrontDesk
     *
     */
    public void displayPatientChecked(Patient patientAtFrontDesk) {
        if (patientAtFrontDesk == null) {
            patientChecked.setText("");
            patientChecked.setIcon(null);
        } else {
            patientChecked.setText(patientAtFrontDesk.getID());
            patientChecked.setIcon(patientImage);
        }
    }

    /**
     *
     * Display a healthcare worker in the vaccination room
     *
     * @param healthcareWorker
     * @param desk: where they are
     *
     */
    public void displayHealthcareWorkerVaccination(HealthcareWorker healthcareWorker, int desk) {
        if (healthcareWorker != null) {
            healthcaresVaccination[desk].setText(healthcareWorker.getID());
            healthcaresImageVaccination[desk].setIcon(healthcareImage);
        } else {
            healthcaresVaccination[desk].setText("");
            healthcaresImageVaccination[desk].setIcon(null);
        }
    }

    /**
     *
     * Display a patient in the vaccination room
     *
     * @param patient
     * @param desk: where they are
     *
     */
    public void displayPatientVaccination(Patient patient, int desk) {
        if (patient != null) {
            patientsVaccination[desk].setText(patient.getID());
            patientsImageVaccination[desk].setIcon(patientImage);
        } else {
            patientsVaccination[desk].setText("");
            patientsImageVaccination[desk].setIcon(null);
        }
    }

    /**
     *
     * Display the vaccines prepared left
     *
     * @param vaccinesAvailable
     */
    public void displayVaccinesAvailable(int vaccinesAvailable) {
        switch (vaccinesAvailable) {
            case 0:
                vaccinesContainer.setIcon(vaccinesContainer0Image);
                break;
            case 1:
                vaccinesContainer.setIcon(vaccinesContainer1Image);
                break;
            case 2:
                vaccinesContainer.setIcon(vaccinesContainer2Image);
                break;
            default:
                vaccinesContainer.setIcon(vaccinesContainer3Image);
                break;
        }
        vaccinesCounter.setText("<html><center>VAX LEFT<br>" + vaccinesAvailable + "</center></html>");

    }

    /**
     *
     * Display the auxiliary working or not
     *
     * @param vaccinePreparerStatus: if 1 means they are resting
     *
     */
    public void displayVaccinePreparerBooth(int vaccinePreparerStatus) {
        if (vaccinePreparerStatus == 1) {
            receptionCounter.setIcon(vaccinationCounterCloseImage);
        } else {
            receptionCounter.setIcon(vaccinationCounterOpenImage);
        }
    }

    /**
     *
     * Display a healthcare worker in the observation room
     *
     * @param healthcareWorker
     * @param desk: where they are
     *
     */
    public void displayHealthcareWorkerObservation(HealthcareWorker healthcareWorker, int desk) {
        if (healthcareWorker != null) {
            healthcaresObservation[desk].setText(healthcareWorker.getID());
            healthcaresImageObservation[desk].setIcon(healthcareImage);
        } else {
            healthcaresObservation[desk].setText("");
            healthcaresImageObservation[desk].setIcon(null);
        }
    }

    /**
     *
     * Display a patient in the observation room
     *
     * @param patient
     * @param desk: where they are
     *
     */
    public void displayPatientObservation(Patient patient, int desk) {
        if (patient != null) {
            patientsObservation[desk].setText(patient.getID());
            patientsImageObservation[desk].setIcon(patientImage);
        } else {
            patientsObservation[desk].setText("");
            patientsImageObservation[desk].setIcon(null);
        }
    }

    /**
     *
     * Display helathcare workers resting
     *
     * @param healthcareWorkers
     *
     */
    public void displayHealthcareWorkersRest(Queue healthcareWorkers) {
        HealthcareWorker healthcareWorker;
        Iterator<Integer> itr = healthcareWorkers.iterator();
        int i = 0;
        while (itr.hasNext()) {
            healthcareWorker = (HealthcareWorker) itr;
            healthcaresRest[i].setText(healthcareWorker.getID());
            healthcaresImageRest[i].setIcon(healthcareImage);
            i++;
        }
        while (i < 10) {
            healthcaresRest[i].setText("");
            healthcaresImageRest[i].setIcon(null);
        }
    }

    /**
     *
     * Display the receptionist resting
     *
     * @param receptionist
     *
     */
    public void displayReceptionistRest(Receptionist receptionist) {
        if (receptionist != null) {
            auxiliariesRest[0].setText(receptionist.getID());
            auxiliariesImageRest[0].setIcon(auxiliaryImage);
        } else {
            auxiliariesRest[0].setText("");
            auxiliariesImageRest[0].setIcon(null);
        }
    }

    /**
     *
     * Display the vaccine preparer resting
     *
     * @param vaccinePreparer
     *
     */
    public void displayVaccinePreparerRest(VaccinePreparer vaccinePreparer) {
        if (vaccinePreparer != null) {
            auxiliariesRest[0].setText(vaccinePreparer.getID());
            auxiliariesImageRest[0].setIcon(auxiliaryImage);
        } else {
            auxiliariesRest[0].setText("");
            auxiliariesImageRest[0].setIcon(null);
        }

    }

    /**
     *
     * Displays information in reception room
     *
     * @param patientsWaiting: at the receprtion queue
     * @param patientAtFrontDesk: being checked by the receptionist
     * @param receptionistStatus: if 2 means they are resting
     *
     */
    public void displayReceptionRoom(Queue patientsWaiting, Patient patientAtFrontDesk, int receptionistStatus) {
        //Display queue of patients
        displayPatientsQueueReception(patientsWaiting);
        // Display the reception booth
        displayReceptionistBooth(receptionistStatus);
        //Display the patient being checked
        displayPatientChecked(patientAtFrontDesk);
    }

    /**
     *
     * Displays information in vaccination room
     *
     * @param desksVaccination: desks in the room
     * @param vaccinePreparerStatus: if 1 means they are resting
     * @param numVaccines: prepared
     *
     */
    public void displayVaccinationRoom(Desk[] desksVaccination, int vaccinePreparerStatus, AtomicInteger numVaccines) {

        //Display people at desks
        Patient patient;
        HealthcareWorker healthcareWorker;
        for (int i = 0; i < 10; i++) {
            patient = desksVaccination[i].getPatient();
            displayPatientVaccination(patient, i);
            healthcareWorker = desksVaccination[i].getWorker();
            displayHealthcareWorkerVaccination(healthcareWorker, i);
        }

        //Display vaccines
        int vaccinesAvailable = numVaccines.get();
        displayVaccinesAvailable(vaccinesAvailable);

        //Display vaccine preparer booth
        displayVaccinePreparerBooth(vaccinePreparerStatus);
    }

    /**
     *
     * Displays information in observation room
     *
     * @param desksObservation: desks in the room
     *
     */
    public void displayObservationRoom(Desk[] desksObservation) {

        //Display people at desks
        Patient patient;
        HealthcareWorker healthcareWorker;
        for (int i = 0; i < 20; i++) {
            patient = desksObservation[i].getPatient();
            displayPatientObservation(patient, i);
            healthcareWorker = desksObservation[i].getWorker();
            displayHealthcareWorkerObservation(healthcareWorker, i);
        }

    }

    /**
     *
     * Displays information in rest room
     *
     * @param healthcareWorkers: resting
     * @param receptionist: resting
     * @param vaccinePreparer: resting
     *
     */
    public void displayRestRoom(Queue healthcareWorkers, Receptionist receptionist, VaccinePreparer vaccinePreparer) {
        //Display healthcare workers
        displayHealthcareWorkersRest(healthcareWorkers);
        //Display auxiliaries
        displayReceptionistRest(receptionist);
        displayVaccinePreparerRest(vaccinePreparer);
       
    }

    /**
     *
     * Update display of the hospital
     *
     * All parameters needed to call all functions
     *
     * @param patientsWaiting
     * @param patientAtFrontDesk
     * @param receptionistStatus
     * @param desksVaccination
     * @param vaccinePreparerStatus
     * @param numVaccines
     * @param desksObservation
     * @param healthcareWorkers
     * @param receptionist
     * @param vaccinePreparer
     *
     */
    public void displayUpdate(Queue patientsWaiting, Patient patientAtFrontDesk,
            int receptionistStatus, Desk[] desksVaccination, int vaccinePreparerStatus,
            AtomicInteger numVaccines, Desk[] desksObservation, Queue healthcareWorkers,
            Receptionist receptionist, VaccinePreparer vaccinePreparer) {

        displayReceptionRoom(patientsWaiting, patientAtFrontDesk, receptionistStatus);
        displayVaccinationRoom(desksVaccination, vaccinePreparerStatus, numVaccines);
        displayObservationRoom(desksObservation);
        displayRestRoom(healthcareWorkers, receptionist, vaccinePreparer);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        receptionRoom = new javax.swing.JPanel();
        patientReception1 = new javax.swing.JLabel();
        patientReception2 = new javax.swing.JLabel();
        patientReception3 = new javax.swing.JLabel();
        patientReception4 = new javax.swing.JLabel();
        patientReception5 = new javax.swing.JLabel();
        patientReception6 = new javax.swing.JLabel();
        patientReception7 = new javax.swing.JLabel();
        patientReception8 = new javax.swing.JLabel();
        patientReception9 = new javax.swing.JLabel();
        patientReception10 = new javax.swing.JLabel();
        patientReception11 = new javax.swing.JLabel();
        patientReception12 = new javax.swing.JLabel();
        patientReception13 = new javax.swing.JLabel();
        patientReception14 = new javax.swing.JLabel();
        patientReception15 = new javax.swing.JLabel();
        patientReception16 = new javax.swing.JLabel();
        patientReception17 = new javax.swing.JLabel();
        patientReception18 = new javax.swing.JLabel();
        patientReception19 = new javax.swing.JLabel();
        patientReception20 = new javax.swing.JLabel();
        patientReception21 = new javax.swing.JLabel();
        patientReception22 = new javax.swing.JLabel();
        receptionExtWall = new javax.swing.JLabel();
        receptionIntWall = new javax.swing.JLabel();
        patientImageReception1 = new javax.swing.JLabel();
        patientImageReception2 = new javax.swing.JLabel();
        patientImageReception3 = new javax.swing.JLabel();
        patientImageReception4 = new javax.swing.JLabel();
        patientImageReception5 = new javax.swing.JLabel();
        patientImageReception6 = new javax.swing.JLabel();
        patientImageReception7 = new javax.swing.JLabel();
        patientImageReception8 = new javax.swing.JLabel();
        patientImageReception9 = new javax.swing.JLabel();
        patientImageReception10 = new javax.swing.JLabel();
        patientImageReception11 = new javax.swing.JLabel();
        patientImageReception12 = new javax.swing.JLabel();
        patientImageReception13 = new javax.swing.JLabel();
        patientImageReception14 = new javax.swing.JLabel();
        patientImageReception15 = new javax.swing.JLabel();
        receptionCounter = new javax.swing.JLabel();
        patientChecked = new javax.swing.JLabel();
        patientImageReception16 = new javax.swing.JLabel();
        patientImageReception17 = new javax.swing.JLabel();
        patientImageReception18 = new javax.swing.JLabel();
        patientImageReception19 = new javax.swing.JLabel();
        patientImageReception20 = new javax.swing.JLabel();
        patientImageReception21 = new javax.swing.JLabel();
        patientImageReception22 = new javax.swing.JLabel();
        patientImageReception35 = new javax.swing.JLabel();
        observationRoom = new javax.swing.JPanel();
        patientObservation1 = new javax.swing.JLabel();
        patientObservation2 = new javax.swing.JLabel();
        patientObservation3 = new javax.swing.JLabel();
        patientObservation4 = new javax.swing.JLabel();
        patientObservation5 = new javax.swing.JLabel();
        patientObservation6 = new javax.swing.JLabel();
        patientObservation7 = new javax.swing.JLabel();
        patientObservation8 = new javax.swing.JLabel();
        patientObservation9 = new javax.swing.JLabel();
        patientObservation10 = new javax.swing.JLabel();
        healthcareObservation1 = new javax.swing.JLabel();
        healthcareObservation2 = new javax.swing.JLabel();
        healthcareObservation3 = new javax.swing.JLabel();
        healthcareObservation4 = new javax.swing.JLabel();
        healthcareObservation5 = new javax.swing.JLabel();
        healthcareObservation6 = new javax.swing.JLabel();
        healthcareObservation7 = new javax.swing.JLabel();
        healthcareObservation8 = new javax.swing.JLabel();
        healthcareObservation9 = new javax.swing.JLabel();
        healthcareObservation10 = new javax.swing.JLabel();
        healthcareObservation11 = new javax.swing.JLabel();
        healthcareObservation12 = new javax.swing.JLabel();
        healthcareObservation13 = new javax.swing.JLabel();
        healthcareObservation14 = new javax.swing.JLabel();
        healthcareObservation15 = new javax.swing.JLabel();
        healthcareObservation16 = new javax.swing.JLabel();
        healthcareObservation17 = new javax.swing.JLabel();
        healthcareObservation18 = new javax.swing.JLabel();
        healthcareObservation19 = new javax.swing.JLabel();
        healthcareObservation20 = new javax.swing.JLabel();
        patientObservation11 = new javax.swing.JLabel();
        patientObservation12 = new javax.swing.JLabel();
        patientObservation13 = new javax.swing.JLabel();
        patientObservation14 = new javax.swing.JLabel();
        patientObservation15 = new javax.swing.JLabel();
        patientObservation16 = new javax.swing.JLabel();
        patientObservation17 = new javax.swing.JLabel();
        patientObservation18 = new javax.swing.JLabel();
        patientObservation19 = new javax.swing.JLabel();
        patientObservation20 = new javax.swing.JLabel();
        observationIntWall = new javax.swing.JLabel();
        observationExtWall = new javax.swing.JLabel();
        patientImageObservation1 = new javax.swing.JLabel();
        patientImageObservation2 = new javax.swing.JLabel();
        healthcareImageObservation1 = new javax.swing.JLabel();
        healthcareImageObservation2 = new javax.swing.JLabel();
        healthcareImageObservation3 = new javax.swing.JLabel();
        healthcareImageObservation4 = new javax.swing.JLabel();
        healthcareImageObservation5 = new javax.swing.JLabel();
        healthcareImageObservation6 = new javax.swing.JLabel();
        healthcareImageObservation7 = new javax.swing.JLabel();
        healthcareImageObservation8 = new javax.swing.JLabel();
        healthcareImageObservation9 = new javax.swing.JLabel();
        healthcareImageObservation10 = new javax.swing.JLabel();
        healthcareImageObservation11 = new javax.swing.JLabel();
        healthcareImageObservation12 = new javax.swing.JLabel();
        healthcareImageObservation13 = new javax.swing.JLabel();
        healthcareImageObservation14 = new javax.swing.JLabel();
        healthcareImageObservation15 = new javax.swing.JLabel();
        healthcareImageObservation16 = new javax.swing.JLabel();
        healthcareImageObservation17 = new javax.swing.JLabel();
        healthcareImageObservation18 = new javax.swing.JLabel();
        healthcareImageObservation19 = new javax.swing.JLabel();
        healthcareImageObservation20 = new javax.swing.JLabel();
        patientImageObservation3 = new javax.swing.JLabel();
        patientImageObservation4 = new javax.swing.JLabel();
        patientImageObservation5 = new javax.swing.JLabel();
        patientImageObservation6 = new javax.swing.JLabel();
        patientImageObservation7 = new javax.swing.JLabel();
        patientImageObservation8 = new javax.swing.JLabel();
        patientImageObservation9 = new javax.swing.JLabel();
        patientImageObservation10 = new javax.swing.JLabel();
        patientImageObservation11 = new javax.swing.JLabel();
        patientImageObservation12 = new javax.swing.JLabel();
        patientImageObservation13 = new javax.swing.JLabel();
        patientImageObservation14 = new javax.swing.JLabel();
        patientImageObservation15 = new javax.swing.JLabel();
        patientImageObservation16 = new javax.swing.JLabel();
        patientImageObservation17 = new javax.swing.JLabel();
        patientImageObservation18 = new javax.swing.JLabel();
        patientImageObservation19 = new javax.swing.JLabel();
        patientImageObservation20 = new javax.swing.JLabel();
        restRoom = new javax.swing.JPanel();
        healthcareRest1 = new javax.swing.JLabel();
        healthcareRest2 = new javax.swing.JLabel();
        healthcareRest3 = new javax.swing.JLabel();
        healthcareRest4 = new javax.swing.JLabel();
        healthcareRest5 = new javax.swing.JLabel();
        healthcareRest6 = new javax.swing.JLabel();
        healthcareRest7 = new javax.swing.JLabel();
        healthcareRest8 = new javax.swing.JLabel();
        healthcareRest9 = new javax.swing.JLabel();
        healthcareRest10 = new javax.swing.JLabel();
        restIntWall = new javax.swing.JLabel();
        restExtWall = new javax.swing.JLabel();
        auxiliaryRest1 = new javax.swing.JLabel();
        auxiliaryRest2 = new javax.swing.JLabel();
        healthcareImageRest1 = new javax.swing.JLabel();
        healthcareImageRest2 = new javax.swing.JLabel();
        healthcareImageRest3 = new javax.swing.JLabel();
        healthcareImageRest4 = new javax.swing.JLabel();
        healthcareImageRest5 = new javax.swing.JLabel();
        healthcareImageRest6 = new javax.swing.JLabel();
        healthcareImageRest7 = new javax.swing.JLabel();
        healthcareImageRest8 = new javax.swing.JLabel();
        healthcareImageRest9 = new javax.swing.JLabel();
        healthcareImageRest10 = new javax.swing.JLabel();
        auxiliaryImageRest1 = new javax.swing.JLabel();
        auxiliaryImageRest2 = new javax.swing.JLabel();
        vaccinationRoom = new javax.swing.JPanel();
        patientVaccination1 = new javax.swing.JLabel();
        patientVaccination2 = new javax.swing.JLabel();
        patientVaccination3 = new javax.swing.JLabel();
        patientVaccination4 = new javax.swing.JLabel();
        patientVaccination5 = new javax.swing.JLabel();
        patientVaccination6 = new javax.swing.JLabel();
        patientVaccination7 = new javax.swing.JLabel();
        patientVaccination8 = new javax.swing.JLabel();
        patientVaccination9 = new javax.swing.JLabel();
        patientVaccination10 = new javax.swing.JLabel();
        healthcareVaccination1 = new javax.swing.JLabel();
        healthcareVaccination2 = new javax.swing.JLabel();
        healthcareVaccination3 = new javax.swing.JLabel();
        healthcareVaccination4 = new javax.swing.JLabel();
        healthcareVaccination5 = new javax.swing.JLabel();
        healthcareVaccination6 = new javax.swing.JLabel();
        healthcareVaccination7 = new javax.swing.JLabel();
        healthcareVaccination8 = new javax.swing.JLabel();
        healthcareVaccination9 = new javax.swing.JLabel();
        healthcareVaccination10 = new javax.swing.JLabel();
        vaccinationIntWall = new javax.swing.JLabel();
        vaccinationExtWall = new javax.swing.JLabel();
        healthcareImageVaccination1 = new javax.swing.JLabel();
        healthcareImageVaccination2 = new javax.swing.JLabel();
        healthcareImageVaccination3 = new javax.swing.JLabel();
        healthcareImageVaccination4 = new javax.swing.JLabel();
        healthcareImageVaccination5 = new javax.swing.JLabel();
        healthcareImageVaccination6 = new javax.swing.JLabel();
        healthcareImageVaccination7 = new javax.swing.JLabel();
        healthcareImageVaccination8 = new javax.swing.JLabel();
        healthcareImageVaccination9 = new javax.swing.JLabel();
        healthcareImageVaccination10 = new javax.swing.JLabel();
        patientImageVaccination1 = new javax.swing.JLabel();
        patientImageVaccination2 = new javax.swing.JLabel();
        patientImageVaccination3 = new javax.swing.JLabel();
        patientImageVaccination4 = new javax.swing.JLabel();
        patientImageVaccination5 = new javax.swing.JLabel();
        patientImageVaccination6 = new javax.swing.JLabel();
        patientImageVaccination7 = new javax.swing.JLabel();
        patientImageVaccination8 = new javax.swing.JLabel();
        patientImageVaccination9 = new javax.swing.JLabel();
        patientImageVaccination10 = new javax.swing.JLabel();
        vaccinesContainer = new javax.swing.JLabel();
        vaccinesCounter = new javax.swing.JLabel();
        vaccinationCounter = new javax.swing.JLabel();
        buttonDesk1 = new javax.swing.JButton();
        buttonDesk2 = new javax.swing.JButton();
        buttonDesk3 = new javax.swing.JButton();
        buttonDesk4 = new javax.swing.JButton();
        buttonDesk5 = new javax.swing.JButton();
        buttonDesk6 = new javax.swing.JButton();
        buttonDesk7 = new javax.swing.JButton();
        buttonDesk8 = new javax.swing.JButton();
        buttonDesk10 = new javax.swing.JButton();
        buttonDesk9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1000, 630));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setMaximumSize(new java.awt.Dimension(1000, 630));
        backgroundPanel.setMinimumSize(new java.awt.Dimension(1000, 630));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(1000, 630));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Linux Biolinum G", 0, 48)); // NOI18N
        title.setText("THREVAX HOSPITAL");
        title.setFocusable(false);
        title.setMaximumSize(new java.awt.Dimension(434, 40));
        title.setMinimumSize(new java.awt.Dimension(434, 40));
        title.setPreferredSize(new java.awt.Dimension(434, 40));

        backButton.setBackground(new java.awt.Color(25, 36, 51));
        backButton.setFont(new java.awt.Font("Ubuntu Condensed", 0, 24)); // NOI18N
        backButton.setIcon(generateImage(".\\src\\main\\java\\IconImages\\goback.png", 35, 35)
        );
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setMargin(new java.awt.Insets(2, 1, 2, 1));
        backButton.setMaximumSize(new java.awt.Dimension(40, 40));
        backButton.setMinimumSize(new java.awt.Dimension(40, 40));
        backButton.setPreferredSize(new java.awt.Dimension(40, 40));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        receptionRoom.setBackground(new java.awt.Color(224, 227, 231));
        receptionRoom.setFocusable(false);
        receptionRoom.setMaximumSize(new java.awt.Dimension(920, 132));
        receptionRoom.setMinimumSize(new java.awt.Dimension(920, 132));

        patientReception1.setBackground(patientBackground);
        patientReception1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception1.setText("0000");
        patientReception1.setBorder(patientBorder);
        patientReception1.setFocusable(false);
        patientReception1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception1.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception1.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception1.setOpaque(true);
        patientReception1.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception2.setBackground(patientBackground);
        patientReception2.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception2.setText("0000");
        patientReception2.setBorder(patientBorder);
        patientReception2.setFocusable(false);
        patientReception2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception2.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception2.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception2.setOpaque(true);
        patientReception2.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception3.setBackground(patientBackground);
        patientReception3.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception3.setText("0000");
        patientReception3.setBorder(patientBorder);
        patientReception3.setFocusable(false);
        patientReception3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception3.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception3.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception3.setOpaque(true);
        patientReception3.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception4.setBackground(patientBackground);
        patientReception4.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception4.setText("0000");
        patientReception4.setBorder(patientBorder);
        patientReception4.setFocusable(false);
        patientReception4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception4.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception4.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception4.setOpaque(true);
        patientReception4.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception5.setBackground(patientBackground);
        patientReception5.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception5.setText("0000");
        patientReception5.setBorder(patientBorder);
        patientReception5.setFocusable(false);
        patientReception5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception5.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception5.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception5.setOpaque(true);
        patientReception5.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception6.setBackground(patientBackground);
        patientReception6.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception6.setText("0000");
        patientReception6.setBorder(patientBorder);
        patientReception6.setFocusable(false);
        patientReception6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception6.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception6.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception6.setOpaque(true);
        patientReception6.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception7.setBackground(patientBackground);
        patientReception7.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception7.setText("0000");
        patientReception7.setBorder(patientBorder);
        patientReception7.setFocusable(false);
        patientReception7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception7.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception7.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception7.setOpaque(true);
        patientReception7.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception8.setBackground(patientBackground);
        patientReception8.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception8.setText("0000");
        patientReception8.setBorder(patientBorder);
        patientReception8.setFocusable(false);
        patientReception8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception8.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception8.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception8.setOpaque(true);
        patientReception8.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception9.setBackground(patientBackground);
        patientReception9.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception9.setText("0000");
        patientReception9.setBorder(patientBorder);
        patientReception9.setFocusable(false);
        patientReception9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception9.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception9.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception9.setOpaque(true);
        patientReception9.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception10.setBackground(patientBackground);
        patientReception10.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception10.setText("0000");
        patientReception10.setBorder(patientBorder);
        patientReception10.setFocusable(false);
        patientReception10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception10.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception10.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception10.setOpaque(true);
        patientReception10.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception11.setBackground(patientBackground);
        patientReception11.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception11.setText("0000");
        patientReception11.setBorder(patientBorder);
        patientReception11.setFocusable(false);
        patientReception11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception11.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception11.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception11.setOpaque(true);
        patientReception11.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception12.setBackground(patientBackground);
        patientReception12.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception12.setText("0000");
        patientReception12.setBorder(patientBorder);
        patientReception12.setFocusable(false);
        patientReception12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception12.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception12.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception12.setOpaque(true);
        patientReception12.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception13.setBackground(patientBackground);
        patientReception13.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception13.setText("0000");
        patientReception13.setBorder(patientBorder);
        patientReception13.setFocusable(false);
        patientReception13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception13.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception13.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception13.setOpaque(true);
        patientReception13.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception14.setBackground(patientBackground);
        patientReception14.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception14.setText("0000");
        patientReception14.setBorder(patientBorder);
        patientReception14.setFocusable(false);
        patientReception14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception14.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception14.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception14.setOpaque(true);
        patientReception14.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception15.setBackground(patientBackground);
        patientReception15.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception15.setText("0000");
        patientReception15.setBorder(patientBorder);
        patientReception15.setFocusable(false);
        patientReception15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception15.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception15.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception15.setOpaque(true);
        patientReception15.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception16.setBackground(patientBackground);
        patientReception16.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception16.setText("0000");
        patientReception16.setBorder(patientBorder);
        patientReception16.setFocusable(false);
        patientReception16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception16.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception16.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception16.setOpaque(true);
        patientReception16.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception17.setBackground(patientBackground);
        patientReception17.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception17.setText("0000");
        patientReception17.setBorder(patientBorder);
        patientReception17.setFocusable(false);
        patientReception17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception17.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception17.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception17.setOpaque(true);
        patientReception17.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception18.setBackground(patientBackground);
        patientReception18.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception18.setText("0000");
        patientReception18.setBorder(patientBorder);
        patientReception18.setFocusable(false);
        patientReception18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception18.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception18.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception18.setOpaque(true);
        patientReception18.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception19.setBackground(patientBackground);
        patientReception19.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception19.setText("0000");
        patientReception19.setBorder(patientBorder);
        patientReception19.setFocusable(false);
        patientReception19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception19.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception19.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception19.setOpaque(true);
        patientReception19.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception20.setBackground(patientBackground);
        patientReception20.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception20.setText("0000");
        patientReception20.setBorder(patientBorder);
        patientReception20.setFocusable(false);
        patientReception20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception20.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception20.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception20.setOpaque(true);
        patientReception20.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception21.setBackground(patientBackground);
        patientReception21.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception21.setText("0000");
        patientReception21.setBorder(patientBorder);
        patientReception21.setFocusable(false);
        patientReception21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception21.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception21.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception21.setOpaque(true);
        patientReception21.setPreferredSize(new java.awt.Dimension(30, 20));

        patientReception22.setBackground(patientBackground);
        patientReception22.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientReception22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientReception22.setText("....");
        patientReception22.setBorder(patientBorder);
        patientReception22.setFocusable(false);
        patientReception22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientReception22.setMaximumSize(new java.awt.Dimension(30, 20));
        patientReception22.setMinimumSize(new java.awt.Dimension(30, 20));
        patientReception22.setOpaque(true);
        patientReception22.setPreferredSize(new java.awt.Dimension(30, 20));

        receptionExtWall.setBackground(new java.awt.Color(153, 153, 153));
        receptionExtWall.setFocusable(false);
        receptionExtWall.setMaximumSize(new java.awt.Dimension(920, 20));
        receptionExtWall.setMinimumSize(new java.awt.Dimension(920, 20));
        receptionExtWall.setOpaque(true);
        receptionExtWall.setPreferredSize(new java.awt.Dimension(920, 20));

        receptionIntWall.setBackground(new java.awt.Color(202, 209, 219));
        receptionIntWall.setFont(new java.awt.Font("Linux Biolinum G", 0, 10)); // NOI18N
        receptionIntWall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receptionIntWall.setText("R E C E P T I O N");
        receptionIntWall.setFocusable(false);
        receptionIntWall.setMaximumSize(new java.awt.Dimension(920, 20));
        receptionIntWall.setMinimumSize(new java.awt.Dimension(920, 20));
        receptionIntWall.setOpaque(true);
        receptionIntWall.setPreferredSize(new java.awt.Dimension(920, 20));

        patientImageReception1.setBackground(patientBackground);
        patientImageReception1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception1.setIcon(patientImage);
        patientImageReception1.setBorder(patientBorder);
        patientImageReception1.setFocusable(false);
        patientImageReception1.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception1.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception1.setOpaque(true);
        patientImageReception1.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception2.setBackground(patientBackground);
        patientImageReception2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception2.setIcon(patientImage);
        patientImageReception2.setBorder(patientBorder);
        patientImageReception2.setFocusable(false);
        patientImageReception2.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception2.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception2.setOpaque(true);
        patientImageReception2.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception3.setBackground(patientBackground);
        patientImageReception3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception3.setIcon(patientImage);
        patientImageReception3.setBorder(patientBorder);
        patientImageReception3.setFocusable(false);
        patientImageReception3.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception3.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception3.setOpaque(true);
        patientImageReception3.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception4.setBackground(patientBackground);
        patientImageReception4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception4.setIcon(patientImage);
        patientImageReception4.setBorder(patientBorder);
        patientImageReception4.setFocusable(false);
        patientImageReception4.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception4.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception4.setOpaque(true);
        patientImageReception4.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception5.setBackground(patientBackground);
        patientImageReception5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception5.setIcon(patientImage);
        patientImageReception5.setBorder(patientBorder);
        patientImageReception5.setFocusable(false);
        patientImageReception5.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception5.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception5.setOpaque(true);
        patientImageReception5.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception6.setBackground(patientBackground);
        patientImageReception6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception6.setIcon(patientImage);
        patientImageReception6.setBorder(patientBorder);
        patientImageReception6.setFocusable(false);
        patientImageReception6.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception6.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception6.setOpaque(true);
        patientImageReception6.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception7.setBackground(patientBackground);
        patientImageReception7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception7.setIcon(patientImage);
        patientImageReception7.setBorder(patientBorder);
        patientImageReception7.setFocusable(false);
        patientImageReception7.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception7.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception7.setOpaque(true);
        patientImageReception7.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception8.setBackground(patientBackground);
        patientImageReception8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception8.setIcon(patientImage);
        patientImageReception8.setBorder(patientBorder);
        patientImageReception8.setFocusable(false);
        patientImageReception8.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception8.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception8.setOpaque(true);
        patientImageReception8.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception9.setBackground(patientBackground);
        patientImageReception9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception9.setIcon(patientImage);
        patientImageReception9.setBorder(patientBorder);
        patientImageReception9.setFocusable(false);
        patientImageReception9.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception9.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception9.setOpaque(true);
        patientImageReception9.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception10.setBackground(patientBackground);
        patientImageReception10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception10.setIcon(patientImage);
        patientImageReception10.setBorder(patientBorder);
        patientImageReception10.setFocusable(false);
        patientImageReception10.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception10.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception10.setOpaque(true);
        patientImageReception10.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception11.setBackground(patientBackground);
        patientImageReception11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception11.setIcon(patientImage);
        patientImageReception11.setBorder(patientBorder);
        patientImageReception11.setFocusable(false);
        patientImageReception11.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception11.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception11.setOpaque(true);
        patientImageReception11.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception12.setBackground(patientBackground);
        patientImageReception12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception12.setIcon(patientImage);
        patientImageReception12.setBorder(patientBorder);
        patientImageReception12.setFocusable(false);
        patientImageReception12.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception12.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception12.setOpaque(true);
        patientImageReception12.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception13.setBackground(patientBackground);
        patientImageReception13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception13.setIcon(patientImage);
        patientImageReception13.setBorder(patientBorder);
        patientImageReception13.setFocusable(false);
        patientImageReception13.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception13.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception13.setOpaque(true);
        patientImageReception13.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception14.setBackground(patientBackground);
        patientImageReception14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception14.setIcon(patientImage);
        patientImageReception14.setBorder(patientBorder);
        patientImageReception14.setFocusable(false);
        patientImageReception14.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception14.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception14.setOpaque(true);
        patientImageReception14.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception15.setBackground(patientBackground);
        patientImageReception15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception15.setIcon(patientImage);
        patientImageReception15.setBorder(patientBorder);
        patientImageReception15.setFocusable(false);
        patientImageReception15.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception15.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception15.setOpaque(true);
        patientImageReception15.setPreferredSize(new java.awt.Dimension(30, 30));

        receptionCounter.setBackground(new java.awt.Color(153, 153, 255));
        receptionCounter.setIcon(receptionCounterOpenImage);
        receptionCounter.setFocusable(false);
        receptionCounter.setMaximumSize(new java.awt.Dimension(40, 80));
        receptionCounter.setMinimumSize(new java.awt.Dimension(40, 80));
        receptionCounter.setOpaque(true);
        receptionCounter.setPreferredSize(new java.awt.Dimension(40, 80));
        receptionCounter.setRequestFocusEnabled(false);

        patientChecked.setBackground(patientBackground);
        patientChecked.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientChecked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientChecked.setText("0000");
        patientChecked.setBorder(patientBorder);
        patientChecked.setFocusable(false);
        patientChecked.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientChecked.setMaximumSize(new java.awt.Dimension(30, 20));
        patientChecked.setMinimumSize(new java.awt.Dimension(30, 20));
        patientChecked.setOpaque(true);
        patientChecked.setPreferredSize(new java.awt.Dimension(30, 20));

        patientImageReception16.setBackground(patientBackground);
        patientImageReception16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception16.setIcon(patientImage);
        patientImageReception16.setBorder(patientBorder);
        patientImageReception16.setFocusable(false);
        patientImageReception16.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception16.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception16.setOpaque(true);
        patientImageReception16.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception17.setBackground(patientBackground);
        patientImageReception17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception17.setIcon(patientImage);
        patientImageReception17.setBorder(patientBorder);
        patientImageReception17.setFocusable(false);
        patientImageReception17.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception17.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception17.setOpaque(true);
        patientImageReception17.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception18.setBackground(patientBackground);
        patientImageReception18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception18.setIcon(patientImage);
        patientImageReception18.setBorder(patientBorder);
        patientImageReception18.setFocusable(false);
        patientImageReception18.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception18.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception18.setOpaque(true);
        patientImageReception18.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception19.setBackground(patientBackground);
        patientImageReception19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception19.setIcon(patientImage);
        patientImageReception19.setBorder(patientBorder);
        patientImageReception19.setFocusable(false);
        patientImageReception19.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception19.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception19.setOpaque(true);
        patientImageReception19.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception20.setBackground(patientBackground);
        patientImageReception20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception20.setIcon(patientImage);
        patientImageReception20.setBorder(patientBorder);
        patientImageReception20.setFocusable(false);
        patientImageReception20.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception20.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception20.setOpaque(true);
        patientImageReception20.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception21.setBackground(patientBackground);
        patientImageReception21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception21.setIcon(patientImage);
        patientImageReception21.setBorder(patientBorder);
        patientImageReception21.setFocusable(false);
        patientImageReception21.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception21.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception21.setOpaque(true);
        patientImageReception21.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception22.setBackground(patientBackground);
        patientImageReception22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception22.setIcon(patientImage);
        patientImageReception22.setBorder(patientBorder);
        patientImageReception22.setFocusable(false);
        patientImageReception22.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception22.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception22.setOpaque(true);
        patientImageReception22.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageReception35.setBackground(patientBackground);
        patientImageReception35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageReception35.setIcon(patientImage);
        patientImageReception35.setBorder(patientBorder);
        patientImageReception35.setFocusable(false);
        patientImageReception35.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageReception35.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageReception35.setOpaque(true);
        patientImageReception35.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout receptionRoomLayout = new javax.swing.GroupLayout(receptionRoom);
        receptionRoom.setLayout(receptionRoomLayout);
        receptionRoomLayout.setHorizontalGroup(
            receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientImageReception4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientReception4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(patientReception3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientImageReception3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(patientReception2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientImageReception2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(patientReception1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientImageReception1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(patientImageReception35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientChecked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(receptionCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(receptionIntWall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receptionExtWall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        receptionRoomLayout.setVerticalGroup(
            receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receptionRoomLayout.createSequentialGroup()
                .addComponent(receptionIntWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(receptionCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(receptionRoomLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(receptionRoomLayout.createSequentialGroup()
                                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientImageReception2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(patientReception3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(patientImageReception3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(receptionRoomLayout.createSequentialGroup()
                                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientImageReception4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(patientReception4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(receptionRoomLayout.createSequentialGroup()
                                .addComponent(patientImageReception35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(patientChecked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(receptionRoomLayout.createSequentialGroup()
                                .addComponent(patientImageReception14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(patientReception14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(receptionRoomLayout.createSequentialGroup()
                                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientImageReception15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageReception13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(patientReception11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientReception15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(receptionRoomLayout.createSequentialGroup()
                                    .addComponent(patientImageReception16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(patientReception16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(receptionRoomLayout.createSequentialGroup()
                                    .addComponent(patientImageReception17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addGroup(receptionRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientReception17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientReception18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientReception19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientReception20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientReception21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientReception22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(patientImageReception18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageReception19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageReception20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageReception21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageReception22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addComponent(receptionExtWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        observationRoom.setBackground(new java.awt.Color(224, 227, 231));
        observationRoom.setFocusable(false);
        observationRoom.setMaximumSize(new java.awt.Dimension(452, 372));
        observationRoom.setMinimumSize(new java.awt.Dimension(452, 372));
        observationRoom.setPreferredSize(new java.awt.Dimension(452, 372));
        observationRoom.setRequestFocusEnabled(false);

        patientObservation1.setBackground(patientBackground);
        patientObservation1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation1.setText("0000");
        patientObservation1.setBorder(patientBorder);
        patientObservation1.setFocusable(false);
        patientObservation1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation1.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation1.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation1.setOpaque(true);
        patientObservation1.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation2.setBackground(patientBackground);
        patientObservation2.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation2.setText("0000");
        patientObservation2.setBorder(patientBorder);
        patientObservation2.setFocusable(false);
        patientObservation2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation2.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation2.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation2.setOpaque(true);
        patientObservation2.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation3.setBackground(patientBackground);
        patientObservation3.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation3.setText("0000");
        patientObservation3.setBorder(patientBorder);
        patientObservation3.setFocusable(false);
        patientObservation3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation3.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation3.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation3.setOpaque(true);
        patientObservation3.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation4.setBackground(patientBackground);
        patientObservation4.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation4.setText("0000");
        patientObservation4.setBorder(patientBorder);
        patientObservation4.setFocusable(false);
        patientObservation4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation4.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation4.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation4.setOpaque(true);
        patientObservation4.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation5.setBackground(patientBackground);
        patientObservation5.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation5.setText("0000");
        patientObservation5.setBorder(patientBorder);
        patientObservation5.setFocusable(false);
        patientObservation5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation5.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation5.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation5.setOpaque(true);
        patientObservation5.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation6.setBackground(patientBackground);
        patientObservation6.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation6.setText("0000");
        patientObservation6.setBorder(patientBorder);
        patientObservation6.setFocusable(false);
        patientObservation6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation6.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation6.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation6.setOpaque(true);
        patientObservation6.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation7.setBackground(patientBackground);
        patientObservation7.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation7.setText("0000");
        patientObservation7.setBorder(patientBorder);
        patientObservation7.setFocusable(false);
        patientObservation7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation7.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation7.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation7.setOpaque(true);
        patientObservation7.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation8.setBackground(patientBackground);
        patientObservation8.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation8.setText("0000");
        patientObservation8.setBorder(patientBorder);
        patientObservation8.setFocusable(false);
        patientObservation8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation8.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation8.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation8.setOpaque(true);
        patientObservation8.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation9.setBackground(patientBackground);
        patientObservation9.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation9.setText("0000");
        patientObservation9.setBorder(patientBorder);
        patientObservation9.setFocusable(false);
        patientObservation9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation9.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation9.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation9.setOpaque(true);
        patientObservation9.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation10.setBackground(patientBackground);
        patientObservation10.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation10.setText("0000");
        patientObservation10.setBorder(patientBorder);
        patientObservation10.setFocusable(false);
        patientObservation10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation10.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation10.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation10.setOpaque(true);
        patientObservation10.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation1.setBackground(healthcareBackground);
        healthcareObservation1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation1.setText("00");
        healthcareObservation1.setBorder(healthcareBorder);
        healthcareObservation1.setFocusable(false);
        healthcareObservation1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation1.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation1.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation1.setOpaque(true);
        healthcareObservation1.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation2.setBackground(healthcareBackground);
        healthcareObservation2.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation2.setText("00");
        healthcareObservation2.setBorder(healthcareBorder);
        healthcareObservation2.setFocusable(false);
        healthcareObservation2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation2.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation2.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation2.setOpaque(true);
        healthcareObservation2.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation3.setBackground(healthcareBackground);
        healthcareObservation3.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation3.setText("00");
        healthcareObservation3.setBorder(healthcareBorder);
        healthcareObservation3.setFocusable(false);
        healthcareObservation3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation3.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation3.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation3.setOpaque(true);
        healthcareObservation3.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation4.setBackground(healthcareBackground);
        healthcareObservation4.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation4.setText("00");
        healthcareObservation4.setBorder(healthcareBorder);
        healthcareObservation4.setFocusable(false);
        healthcareObservation4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation4.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation4.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation4.setOpaque(true);
        healthcareObservation4.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation5.setBackground(healthcareBackground);
        healthcareObservation5.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation5.setText("00");
        healthcareObservation5.setBorder(healthcareBorder);
        healthcareObservation5.setFocusable(false);
        healthcareObservation5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation5.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation5.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation5.setOpaque(true);
        healthcareObservation5.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation6.setBackground(healthcareBackground);
        healthcareObservation6.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation6.setText("00");
        healthcareObservation6.setBorder(healthcareBorder);
        healthcareObservation6.setFocusable(false);
        healthcareObservation6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation6.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation6.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation6.setOpaque(true);
        healthcareObservation6.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation7.setBackground(healthcareBackground);
        healthcareObservation7.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation7.setText("00");
        healthcareObservation7.setBorder(healthcareBorder);
        healthcareObservation7.setFocusable(false);
        healthcareObservation7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation7.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation7.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation7.setOpaque(true);
        healthcareObservation7.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation8.setBackground(healthcareBackground);
        healthcareObservation8.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation8.setText("00");
        healthcareObservation8.setBorder(healthcareBorder);
        healthcareObservation8.setFocusable(false);
        healthcareObservation8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation8.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation8.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation8.setOpaque(true);
        healthcareObservation8.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation9.setBackground(healthcareBackground);
        healthcareObservation9.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation9.setText("00");
        healthcareObservation9.setBorder(healthcareBorder);
        healthcareObservation9.setFocusable(false);
        healthcareObservation9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation9.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation9.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation9.setOpaque(true);
        healthcareObservation9.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation10.setBackground(healthcareBackground);
        healthcareObservation10.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation10.setText("00");
        healthcareObservation10.setBorder(healthcareBorder);
        healthcareObservation10.setFocusable(false);
        healthcareObservation10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation10.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation10.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation10.setOpaque(true);
        healthcareObservation10.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation11.setBackground(healthcareBackground);
        healthcareObservation11.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation11.setText("00");
        healthcareObservation11.setBorder(healthcareBorder);
        healthcareObservation11.setFocusable(false);
        healthcareObservation11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation11.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation11.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation11.setOpaque(true);
        healthcareObservation11.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation12.setBackground(healthcareBackground);
        healthcareObservation12.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation12.setText("00");
        healthcareObservation12.setBorder(healthcareBorder);
        healthcareObservation12.setFocusable(false);
        healthcareObservation12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation12.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation12.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation12.setOpaque(true);
        healthcareObservation12.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation13.setBackground(healthcareBackground);
        healthcareObservation13.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation13.setText("00");
        healthcareObservation13.setBorder(healthcareBorder);
        healthcareObservation13.setFocusable(false);
        healthcareObservation13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation13.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation13.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation13.setOpaque(true);
        healthcareObservation13.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation14.setBackground(healthcareBackground);
        healthcareObservation14.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation14.setText("00");
        healthcareObservation14.setBorder(healthcareBorder);
        healthcareObservation14.setFocusable(false);
        healthcareObservation14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation14.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation14.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation14.setOpaque(true);
        healthcareObservation14.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation15.setBackground(healthcareBackground);
        healthcareObservation15.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation15.setText("00");
        healthcareObservation15.setBorder(healthcareBorder);
        healthcareObservation15.setFocusable(false);
        healthcareObservation15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation15.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation15.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation15.setOpaque(true);
        healthcareObservation15.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation16.setBackground(healthcareBackground);
        healthcareObservation16.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation16.setText("00");
        healthcareObservation16.setBorder(healthcareBorder);
        healthcareObservation16.setFocusable(false);
        healthcareObservation16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation16.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation16.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation16.setOpaque(true);
        healthcareObservation16.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation17.setBackground(healthcareBackground);
        healthcareObservation17.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation17.setText("00");
        healthcareObservation17.setBorder(healthcareBorder);
        healthcareObservation17.setFocusable(false);
        healthcareObservation17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation17.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation17.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation17.setOpaque(true);
        healthcareObservation17.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation18.setBackground(healthcareBackground);
        healthcareObservation18.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation18.setText("00");
        healthcareObservation18.setBorder(healthcareBorder);
        healthcareObservation18.setFocusable(false);
        healthcareObservation18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation18.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation18.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation18.setOpaque(true);
        healthcareObservation18.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation19.setBackground(healthcareBackground);
        healthcareObservation19.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation19.setText("00");
        healthcareObservation19.setBorder(healthcareBorder);
        healthcareObservation19.setFocusable(false);
        healthcareObservation19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation19.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation19.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation19.setOpaque(true);
        healthcareObservation19.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareObservation20.setBackground(healthcareBackground);
        healthcareObservation20.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareObservation20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareObservation20.setText("00");
        healthcareObservation20.setBorder(healthcareBorder);
        healthcareObservation20.setFocusable(false);
        healthcareObservation20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareObservation20.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareObservation20.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareObservation20.setOpaque(true);
        healthcareObservation20.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation11.setBackground(patientBackground);
        patientObservation11.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation11.setText("0000");
        patientObservation11.setBorder(patientBorder);
        patientObservation11.setFocusable(false);
        patientObservation11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation11.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation11.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation11.setOpaque(true);
        patientObservation11.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation12.setBackground(patientBackground);
        patientObservation12.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation12.setText("0000");
        patientObservation12.setBorder(patientBorder);
        patientObservation12.setFocusable(false);
        patientObservation12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation12.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation12.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation12.setOpaque(true);
        patientObservation12.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation13.setBackground(patientBackground);
        patientObservation13.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation13.setText("0000");
        patientObservation13.setBorder(patientBorder);
        patientObservation13.setFocusable(false);
        patientObservation13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation13.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation13.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation13.setOpaque(true);
        patientObservation13.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation14.setBackground(patientBackground);
        patientObservation14.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation14.setText("0000");
        patientObservation14.setBorder(patientBorder);
        patientObservation14.setFocusable(false);
        patientObservation14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation14.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation14.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation14.setOpaque(true);
        patientObservation14.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation15.setBackground(patientBackground);
        patientObservation15.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation15.setText("0000");
        patientObservation15.setBorder(patientBorder);
        patientObservation15.setFocusable(false);
        patientObservation15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation15.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation15.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation15.setOpaque(true);
        patientObservation15.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation16.setBackground(patientBackground);
        patientObservation16.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation16.setText("0000");
        patientObservation16.setBorder(patientBorder);
        patientObservation16.setFocusable(false);
        patientObservation16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation16.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation16.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation16.setOpaque(true);
        patientObservation16.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation17.setBackground(patientBackground);
        patientObservation17.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation17.setText("0000");
        patientObservation17.setBorder(patientBorder);
        patientObservation17.setFocusable(false);
        patientObservation17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation17.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation17.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation17.setOpaque(true);
        patientObservation17.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation18.setBackground(patientBackground);
        patientObservation18.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation18.setText("0000");
        patientObservation18.setBorder(patientBorder);
        patientObservation18.setFocusable(false);
        patientObservation18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation18.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation18.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation18.setOpaque(true);
        patientObservation18.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation19.setBackground(patientBackground);
        patientObservation19.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation19.setText("0000");
        patientObservation19.setBorder(patientBorder);
        patientObservation19.setFocusable(false);
        patientObservation19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation19.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation19.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation19.setOpaque(true);
        patientObservation19.setPreferredSize(new java.awt.Dimension(30, 20));

        patientObservation20.setBackground(patientBackground);
        patientObservation20.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientObservation20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientObservation20.setText("0000");
        patientObservation20.setBorder(patientBorder);
        patientObservation20.setFocusable(false);
        patientObservation20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientObservation20.setMaximumSize(new java.awt.Dimension(30, 20));
        patientObservation20.setMinimumSize(new java.awt.Dimension(30, 20));
        patientObservation20.setOpaque(true);
        patientObservation20.setPreferredSize(new java.awt.Dimension(30, 20));

        observationIntWall.setBackground(new java.awt.Color(202, 209, 219));
        observationIntWall.setFont(new java.awt.Font("Linux Biolinum G", 0, 10)); // NOI18N
        observationIntWall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        observationIntWall.setText("O B S E R V A T I O N      R O O M");
        observationIntWall.setFocusable(false);
        observationIntWall.setMaximumSize(new java.awt.Dimension(452, 20));
        observationIntWall.setMinimumSize(new java.awt.Dimension(452, 20));
        observationIntWall.setOpaque(true);
        observationIntWall.setPreferredSize(new java.awt.Dimension(452, 20));

        observationExtWall.setBackground(new java.awt.Color(153, 153, 153));
        observationExtWall.setFocusable(false);
        observationExtWall.setMaximumSize(new java.awt.Dimension(452, 20));
        observationExtWall.setMinimumSize(new java.awt.Dimension(452, 20));
        observationExtWall.setOpaque(true);
        observationExtWall.setPreferredSize(new java.awt.Dimension(452, 20));

        patientImageObservation1.setBackground(patientBackground);
        patientImageObservation1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation1.setIcon(patientImage);
        patientImageObservation1.setBorder(patientBorder);
        patientImageObservation1.setFocusable(false);
        patientImageObservation1.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation1.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation1.setOpaque(true);
        patientImageObservation1.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation2.setBackground(patientBackground);
        patientImageObservation2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation2.setIcon(patientImage);
        patientImageObservation2.setBorder(patientBorder);
        patientImageObservation2.setFocusable(false);
        patientImageObservation2.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation2.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation2.setOpaque(true);
        patientImageObservation2.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation1.setBackground(healthcareBackground);
        healthcareImageObservation1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation1.setIcon(healthcareImage);
        healthcareImageObservation1.setBorder(healthcareBorder);
        healthcareImageObservation1.setFocusable(false);
        healthcareImageObservation1.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation1.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation1.setOpaque(true);
        healthcareImageObservation1.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation2.setBackground(healthcareBackground);
        healthcareImageObservation2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation2.setIcon(healthcareImage);
        healthcareImageObservation2.setBorder(healthcareBorder);
        healthcareImageObservation2.setFocusable(false);
        healthcareImageObservation2.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation2.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation2.setOpaque(true);
        healthcareImageObservation2.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation3.setBackground(healthcareBackground);
        healthcareImageObservation3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation3.setIcon(healthcareImage);
        healthcareImageObservation3.setBorder(healthcareBorder);
        healthcareImageObservation3.setFocusable(false);
        healthcareImageObservation3.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation3.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation3.setOpaque(true);
        healthcareImageObservation3.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation4.setBackground(healthcareBackground);
        healthcareImageObservation4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation4.setIcon(healthcareImage);
        healthcareImageObservation4.setBorder(healthcareBorder);
        healthcareImageObservation4.setFocusable(false);
        healthcareImageObservation4.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation4.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation4.setOpaque(true);
        healthcareImageObservation4.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation5.setBackground(healthcareBackground);
        healthcareImageObservation5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation5.setIcon(healthcareImage);
        healthcareImageObservation5.setBorder(healthcareBorder);
        healthcareImageObservation5.setFocusable(false);
        healthcareImageObservation5.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation5.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation5.setOpaque(true);
        healthcareImageObservation5.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation6.setBackground(healthcareBackground);
        healthcareImageObservation6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation6.setIcon(healthcareImage);
        healthcareImageObservation6.setBorder(healthcareBorder);
        healthcareImageObservation6.setFocusable(false);
        healthcareImageObservation6.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation6.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation6.setOpaque(true);
        healthcareImageObservation6.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation7.setBackground(healthcareBackground);
        healthcareImageObservation7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation7.setIcon(healthcareImage);
        healthcareImageObservation7.setBorder(healthcareBorder);
        healthcareImageObservation7.setFocusable(false);
        healthcareImageObservation7.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation7.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation7.setOpaque(true);
        healthcareImageObservation7.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation8.setBackground(healthcareBackground);
        healthcareImageObservation8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation8.setIcon(healthcareImage);
        healthcareImageObservation8.setBorder(healthcareBorder);
        healthcareImageObservation8.setFocusable(false);
        healthcareImageObservation8.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation8.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation8.setOpaque(true);
        healthcareImageObservation8.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation9.setBackground(healthcareBackground);
        healthcareImageObservation9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation9.setIcon(healthcareImage);
        healthcareImageObservation9.setBorder(healthcareBorder);
        healthcareImageObservation9.setFocusable(false);
        healthcareImageObservation9.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation9.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation9.setOpaque(true);
        healthcareImageObservation9.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation10.setBackground(healthcareBackground);
        healthcareImageObservation10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation10.setIcon(healthcareImage);
        healthcareImageObservation10.setBorder(healthcareBorder);
        healthcareImageObservation10.setFocusable(false);
        healthcareImageObservation10.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation10.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation10.setOpaque(true);
        healthcareImageObservation10.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation11.setBackground(healthcareBackground);
        healthcareImageObservation11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation11.setIcon(healthcareImage);
        healthcareImageObservation11.setBorder(healthcareBorder);
        healthcareImageObservation11.setFocusable(false);
        healthcareImageObservation11.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation11.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation11.setOpaque(true);
        healthcareImageObservation11.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation12.setBackground(healthcareBackground);
        healthcareImageObservation12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation12.setIcon(healthcareImage);
        healthcareImageObservation12.setBorder(healthcareBorder);
        healthcareImageObservation12.setFocusable(false);
        healthcareImageObservation12.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation12.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation12.setOpaque(true);
        healthcareImageObservation12.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation13.setBackground(healthcareBackground);
        healthcareImageObservation13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation13.setIcon(healthcareImage);
        healthcareImageObservation13.setBorder(healthcareBorder);
        healthcareImageObservation13.setFocusable(false);
        healthcareImageObservation13.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation13.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation13.setOpaque(true);
        healthcareImageObservation13.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation14.setBackground(healthcareBackground);
        healthcareImageObservation14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation14.setIcon(healthcareImage);
        healthcareImageObservation14.setBorder(healthcareBorder);
        healthcareImageObservation14.setFocusable(false);
        healthcareImageObservation14.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation14.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation14.setOpaque(true);
        healthcareImageObservation14.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation15.setBackground(healthcareBackground);
        healthcareImageObservation15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation15.setIcon(healthcareImage);
        healthcareImageObservation15.setBorder(healthcareBorder);
        healthcareImageObservation15.setFocusable(false);
        healthcareImageObservation15.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation15.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation15.setOpaque(true);
        healthcareImageObservation15.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation16.setBackground(healthcareBackground);
        healthcareImageObservation16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation16.setIcon(healthcareImage);
        healthcareImageObservation16.setBorder(healthcareBorder);
        healthcareImageObservation16.setFocusable(false);
        healthcareImageObservation16.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation16.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation16.setOpaque(true);
        healthcareImageObservation16.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation17.setBackground(healthcareBackground);
        healthcareImageObservation17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation17.setIcon(healthcareImage);
        healthcareImageObservation17.setBorder(healthcareBorder);
        healthcareImageObservation17.setFocusable(false);
        healthcareImageObservation17.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation17.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation17.setOpaque(true);
        healthcareImageObservation17.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation18.setBackground(healthcareBackground);
        healthcareImageObservation18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation18.setIcon(healthcareImage);
        healthcareImageObservation18.setBorder(healthcareBorder);
        healthcareImageObservation18.setFocusable(false);
        healthcareImageObservation18.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation18.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation18.setOpaque(true);
        healthcareImageObservation18.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation19.setBackground(healthcareBackground);
        healthcareImageObservation19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation19.setIcon(healthcareImage);
        healthcareImageObservation19.setBorder(healthcareBorder);
        healthcareImageObservation19.setFocusable(false);
        healthcareImageObservation19.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation19.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation19.setOpaque(true);
        healthcareImageObservation19.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageObservation20.setBackground(healthcareBackground);
        healthcareImageObservation20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageObservation20.setIcon(healthcareImage);
        healthcareImageObservation20.setBorder(healthcareBorder);
        healthcareImageObservation20.setFocusable(false);
        healthcareImageObservation20.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation20.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageObservation20.setOpaque(true);
        healthcareImageObservation20.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation3.setBackground(patientBackground);
        patientImageObservation3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation3.setIcon(patientImage);
        patientImageObservation3.setBorder(patientBorder);
        patientImageObservation3.setFocusable(false);
        patientImageObservation3.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation3.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation3.setOpaque(true);
        patientImageObservation3.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation4.setBackground(patientBackground);
        patientImageObservation4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation4.setIcon(patientImage);
        patientImageObservation4.setBorder(patientBorder);
        patientImageObservation4.setFocusable(false);
        patientImageObservation4.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation4.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation4.setOpaque(true);
        patientImageObservation4.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation5.setBackground(patientBackground);
        patientImageObservation5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation5.setIcon(patientImage);
        patientImageObservation5.setBorder(patientBorder);
        patientImageObservation5.setFocusable(false);
        patientImageObservation5.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation5.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation5.setOpaque(true);
        patientImageObservation5.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation6.setBackground(patientBackground);
        patientImageObservation6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation6.setIcon(patientImage);
        patientImageObservation6.setBorder(patientBorder);
        patientImageObservation6.setFocusable(false);
        patientImageObservation6.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation6.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation6.setOpaque(true);
        patientImageObservation6.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation7.setBackground(patientBackground);
        patientImageObservation7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation7.setIcon(patientImage);
        patientImageObservation7.setBorder(patientBorder);
        patientImageObservation7.setFocusable(false);
        patientImageObservation7.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation7.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation7.setOpaque(true);
        patientImageObservation7.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation8.setBackground(patientBackground);
        patientImageObservation8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation8.setIcon(patientImage);
        patientImageObservation8.setBorder(patientBorder);
        patientImageObservation8.setFocusable(false);
        patientImageObservation8.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation8.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation8.setOpaque(true);
        patientImageObservation8.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation9.setBackground(patientBackground);
        patientImageObservation9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation9.setIcon(patientImage);
        patientImageObservation9.setBorder(patientBorder);
        patientImageObservation9.setFocusable(false);
        patientImageObservation9.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation9.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation9.setOpaque(true);
        patientImageObservation9.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation10.setBackground(patientBackground);
        patientImageObservation10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation10.setIcon(patientImage);
        patientImageObservation10.setBorder(patientBorder);
        patientImageObservation10.setFocusable(false);
        patientImageObservation10.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation10.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation10.setOpaque(true);
        patientImageObservation10.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation11.setBackground(patientBackground);
        patientImageObservation11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation11.setIcon(patientImage);
        patientImageObservation11.setBorder(patientBorder);
        patientImageObservation11.setFocusable(false);
        patientImageObservation11.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation11.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation11.setOpaque(true);
        patientImageObservation11.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation12.setBackground(patientBackground);
        patientImageObservation12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation12.setIcon(patientImage);
        patientImageObservation12.setBorder(patientBorder);
        patientImageObservation12.setFocusable(false);
        patientImageObservation12.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation12.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation12.setOpaque(true);
        patientImageObservation12.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation13.setBackground(patientBackground);
        patientImageObservation13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation13.setIcon(patientImage);
        patientImageObservation13.setBorder(patientBorder);
        patientImageObservation13.setFocusable(false);
        patientImageObservation13.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation13.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation13.setOpaque(true);
        patientImageObservation13.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation14.setBackground(patientBackground);
        patientImageObservation14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation14.setIcon(patientImage);
        patientImageObservation14.setBorder(patientBorder);
        patientImageObservation14.setFocusable(false);
        patientImageObservation14.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation14.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation14.setOpaque(true);
        patientImageObservation14.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation15.setBackground(patientBackground);
        patientImageObservation15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation15.setIcon(patientImage);
        patientImageObservation15.setBorder(patientBorder);
        patientImageObservation15.setFocusable(false);
        patientImageObservation15.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation15.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation15.setOpaque(true);
        patientImageObservation15.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation16.setBackground(patientBackground);
        patientImageObservation16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation16.setIcon(patientImage);
        patientImageObservation16.setBorder(patientBorder);
        patientImageObservation16.setFocusable(false);
        patientImageObservation16.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation16.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation16.setOpaque(true);
        patientImageObservation16.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation17.setBackground(patientBackground);
        patientImageObservation17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation17.setIcon(patientImage);
        patientImageObservation17.setBorder(patientBorder);
        patientImageObservation17.setFocusable(false);
        patientImageObservation17.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation17.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation17.setOpaque(true);
        patientImageObservation17.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation18.setBackground(patientBackground);
        patientImageObservation18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation18.setIcon(patientImage);
        patientImageObservation18.setBorder(patientBorder);
        patientImageObservation18.setFocusable(false);
        patientImageObservation18.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation18.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation18.setOpaque(true);
        patientImageObservation18.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation19.setBackground(patientBackground);
        patientImageObservation19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation19.setIcon(patientImage);
        patientImageObservation19.setBorder(patientBorder);
        patientImageObservation19.setFocusable(false);
        patientImageObservation19.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation19.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation19.setOpaque(true);
        patientImageObservation19.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageObservation20.setBackground(patientBackground);
        patientImageObservation20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageObservation20.setIcon(patientImage);
        patientImageObservation20.setBorder(patientBorder);
        patientImageObservation20.setFocusable(false);
        patientImageObservation20.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageObservation20.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageObservation20.setOpaque(true);
        patientImageObservation20.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout observationRoomLayout = new javax.swing.GroupLayout(observationRoom);
        observationRoom.setLayout(observationRoomLayout);
        observationRoomLayout.setHorizontalGroup(
            observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(observationRoomLayout.createSequentialGroup()
                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(observationIntWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(observationRoomLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(patientObservation19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientImageObservation19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(healthcareObservation19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(healthcareImageObservation19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(patientImageObservation17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientObservation17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, observationRoomLayout.createSequentialGroup()
                                        .addComponent(patientObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(patientImageObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareImageObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientImageObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(patientImageObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(observationRoomLayout.createSequentialGroup()
                                                .addComponent(healthcareImageObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(patientImageObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(observationRoomLayout.createSequentialGroup()
                                                .addComponent(healthcareObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(patientObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(6, 6, 6)
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(healthcareImageObservation17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientImageObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareImageObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, observationRoomLayout.createSequentialGroup()
                                            .addComponent(healthcareObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(patientObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(healthcareObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(observationRoomLayout.createSequentialGroup()
                                            .addComponent(healthcareImageObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(patientImageObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(healthcareImageObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(observationRoomLayout.createSequentialGroup()
                                            .addComponent(healthcareImageObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(patientImageObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(healthcareImageObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(observationRoomLayout.createSequentialGroup()
                                            .addComponent(healthcareObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(patientObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(healthcareObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(healthcareObservation17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(patientObservation20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageObservation20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(healthcareObservation20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageObservation20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientObservation18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageObservation18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(healthcareObservation18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientObservation16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, observationRoomLayout.createSequentialGroup()
                                        .addComponent(healthcareImageObservation18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientImageObservation16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(healthcareImageObservation16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareObservation16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(patientObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(patientImageObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareImageObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientImageObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(patientObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(patientImageObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareImageObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientImageObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createSequentialGroup()
                                        .addComponent(patientObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(healthcareObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(patientObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(healthcareImageObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addComponent(patientObservation14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareObservation14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(patientObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addComponent(patientImageObservation14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareImageObservation14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(patientImageObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareImageObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addComponent(patientImageObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareImageObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(patientImageObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareImageObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(observationRoomLayout.createSequentialGroup()
                .addComponent(observationExtWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        observationRoomLayout.setVerticalGroup(
            observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(observationRoomLayout.createSequentialGroup()
                .addComponent(observationIntWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(observationRoomLayout.createSequentialGroup()
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(healthcareImageObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(patientImageObservation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(observationRoomLayout.createSequentialGroup()
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientImageObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(healthcareImageObservation17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(observationRoomLayout.createSequentialGroup()
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientImageObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(healthcareObservation4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(healthcareObservation6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(healthcareObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(healthcareObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientObservation10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(patientObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(healthcareObservation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(healthcareImageObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientImageObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientImageObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientImageObservation19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientImageObservation17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(healthcareImageObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientImageObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(healthcareImageObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(healthcareImageObservation19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, 0)
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(healthcareObservation19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientImageObservation16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageObservation20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageObservation18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageObservation14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageObservation14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(healthcareImageObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientImageObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(observationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientObservation20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareObservation12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(observationExtWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(observationRoomLayout.createSequentialGroup()
                        .addComponent(patientImageObservation8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        restRoom.setBackground(new java.awt.Color(224, 227, 231));
        restRoom.setFocusable(false);
        restRoom.setMaximumSize(new java.awt.Dimension(150, 372));
        restRoom.setMinimumSize(new java.awt.Dimension(150, 372));
        restRoom.setPreferredSize(new java.awt.Dimension(150, 372));

        healthcareRest1.setBackground(healthcareBackground);
        healthcareRest1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest1.setText("00");
        healthcareRest1.setBorder(healthcareBorder);
        healthcareRest1.setFocusable(false);
        healthcareRest1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest1.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest1.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest1.setOpaque(true);
        healthcareRest1.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest1.setRequestFocusEnabled(false);

        healthcareRest2.setBackground(healthcareBackground);
        healthcareRest2.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest2.setText("00");
        healthcareRest2.setBorder(healthcareBorder);
        healthcareRest2.setFocusable(false);
        healthcareRest2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest2.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest2.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest2.setOpaque(true);
        healthcareRest2.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest2.setRequestFocusEnabled(false);

        healthcareRest3.setBackground(healthcareBackground);
        healthcareRest3.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest3.setText("00");
        healthcareRest3.setBorder(healthcareBorder);
        healthcareRest3.setFocusable(false);
        healthcareRest3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest3.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest3.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest3.setOpaque(true);
        healthcareRest3.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest3.setRequestFocusEnabled(false);

        healthcareRest4.setBackground(healthcareBackground);
        healthcareRest4.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest4.setText("00");
        healthcareRest4.setBorder(healthcareBorder);
        healthcareRest4.setFocusable(false);
        healthcareRest4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest4.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest4.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest4.setOpaque(true);
        healthcareRest4.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest4.setRequestFocusEnabled(false);

        healthcareRest5.setBackground(healthcareBackground);
        healthcareRest5.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest5.setText("00");
        healthcareRest5.setBorder(healthcareBorder);
        healthcareRest5.setFocusable(false);
        healthcareRest5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest5.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest5.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest5.setOpaque(true);
        healthcareRest5.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest5.setRequestFocusEnabled(false);

        healthcareRest6.setBackground(healthcareBackground);
        healthcareRest6.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest6.setText("00");
        healthcareRest6.setBorder(healthcareBorder);
        healthcareRest6.setFocusable(false);
        healthcareRest6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest6.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest6.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest6.setOpaque(true);
        healthcareRest6.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest6.setRequestFocusEnabled(false);

        healthcareRest7.setBackground(healthcareBackground);
        healthcareRest7.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest7.setText("00");
        healthcareRest7.setBorder(healthcareBorder);
        healthcareRest7.setFocusable(false);
        healthcareRest7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest7.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest7.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest7.setOpaque(true);
        healthcareRest7.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest7.setRequestFocusEnabled(false);

        healthcareRest8.setBackground(healthcareBackground);
        healthcareRest8.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest8.setText("00");
        healthcareRest8.setBorder(healthcareBorder);
        healthcareRest8.setFocusable(false);
        healthcareRest8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest8.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest8.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest8.setOpaque(true);
        healthcareRest8.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest8.setRequestFocusEnabled(false);

        healthcareRest9.setBackground(healthcareBackground);
        healthcareRest9.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest9.setText("00");
        healthcareRest9.setBorder(healthcareBorder);
        healthcareRest9.setFocusable(false);
        healthcareRest9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest9.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest9.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest9.setOpaque(true);
        healthcareRest9.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest9.setRequestFocusEnabled(false);

        healthcareRest10.setBackground(healthcareBackground);
        healthcareRest10.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareRest10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareRest10.setText("00");
        healthcareRest10.setBorder(healthcareBorder);
        healthcareRest10.setFocusable(false);
        healthcareRest10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareRest10.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareRest10.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareRest10.setOpaque(true);
        healthcareRest10.setPreferredSize(new java.awt.Dimension(30, 20));
        healthcareRest10.setRequestFocusEnabled(false);

        restIntWall.setBackground(new java.awt.Color(202, 209, 219));
        restIntWall.setFont(new java.awt.Font("Linux Biolinum G", 0, 10)); // NOI18N
        restIntWall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restIntWall.setText("L O C K E R      R O O M");
        restIntWall.setFocusable(false);
        restIntWall.setMaximumSize(new java.awt.Dimension(150, 20));
        restIntWall.setMinimumSize(new java.awt.Dimension(150, 20));
        restIntWall.setOpaque(true);
        restIntWall.setPreferredSize(new java.awt.Dimension(150, 20));

        restExtWall.setBackground(new java.awt.Color(153, 153, 153));
        restExtWall.setFocusable(false);
        restExtWall.setMaximumSize(new java.awt.Dimension(150, 20));
        restExtWall.setMinimumSize(new java.awt.Dimension(150, 20));
        restExtWall.setOpaque(true);
        restExtWall.setPreferredSize(new java.awt.Dimension(150, 20));

        auxiliaryRest1.setBackground(auxiliaryBackground);
        auxiliaryRest1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        auxiliaryRest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        auxiliaryRest1.setText("00");
        auxiliaryRest1.setBorder(auxiliaryBorder);
        auxiliaryRest1.setFocusable(false);
        auxiliaryRest1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        auxiliaryRest1.setMaximumSize(new java.awt.Dimension(30, 20));
        auxiliaryRest1.setMinimumSize(new java.awt.Dimension(30, 20));
        auxiliaryRest1.setOpaque(true);
        auxiliaryRest1.setPreferredSize(new java.awt.Dimension(30, 20));
        auxiliaryRest1.setRequestFocusEnabled(false);

        auxiliaryRest2.setBackground(auxiliaryBackground);
        auxiliaryRest2.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        auxiliaryRest2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        auxiliaryRest2.setText("00");
        auxiliaryRest2.setBorder(auxiliaryBorder);
        auxiliaryRest2.setFocusable(false);
        auxiliaryRest2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        auxiliaryRest2.setMaximumSize(new java.awt.Dimension(30, 20));
        auxiliaryRest2.setMinimumSize(new java.awt.Dimension(30, 20));
        auxiliaryRest2.setOpaque(true);
        auxiliaryRest2.setPreferredSize(new java.awt.Dimension(30, 20));
        auxiliaryRest2.setRequestFocusEnabled(false);

        healthcareImageRest1.setBackground(healthcareBackground);
        healthcareImageRest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest1.setIcon(healthcareImage);
        healthcareImageRest1.setBorder(healthcareBorder);
        healthcareImageRest1.setFocusable(false);
        healthcareImageRest1.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest1.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest1.setOpaque(true);
        healthcareImageRest1.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest2.setBackground(healthcareBackground);
        healthcareImageRest2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest2.setIcon(healthcareImage);
        healthcareImageRest2.setBorder(healthcareBorder);
        healthcareImageRest2.setFocusable(false);
        healthcareImageRest2.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest2.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest2.setOpaque(true);
        healthcareImageRest2.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest3.setBackground(healthcareBackground);
        healthcareImageRest3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest3.setIcon(healthcareImage);
        healthcareImageRest3.setBorder(healthcareBorder);
        healthcareImageRest3.setFocusable(false);
        healthcareImageRest3.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest3.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest3.setOpaque(true);
        healthcareImageRest3.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest4.setBackground(healthcareBackground);
        healthcareImageRest4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest4.setIcon(healthcareImage);
        healthcareImageRest4.setBorder(healthcareBorder);
        healthcareImageRest4.setFocusable(false);
        healthcareImageRest4.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest4.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest4.setOpaque(true);
        healthcareImageRest4.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest5.setBackground(healthcareBackground);
        healthcareImageRest5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest5.setIcon(healthcareImage);
        healthcareImageRest5.setBorder(healthcareBorder);
        healthcareImageRest5.setFocusable(false);
        healthcareImageRest5.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest5.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest5.setOpaque(true);
        healthcareImageRest5.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest6.setBackground(healthcareBackground);
        healthcareImageRest6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest6.setIcon(healthcareImage);
        healthcareImageRest6.setBorder(healthcareBorder);
        healthcareImageRest6.setFocusable(false);
        healthcareImageRest6.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest6.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest6.setOpaque(true);
        healthcareImageRest6.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest7.setBackground(healthcareBackground);
        healthcareImageRest7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest7.setIcon(healthcareImage);
        healthcareImageRest7.setBorder(healthcareBorder);
        healthcareImageRest7.setFocusable(false);
        healthcareImageRest7.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest7.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest7.setOpaque(true);
        healthcareImageRest7.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest8.setBackground(healthcareBackground);
        healthcareImageRest8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest8.setIcon(healthcareImage);
        healthcareImageRest8.setBorder(healthcareBorder);
        healthcareImageRest8.setFocusable(false);
        healthcareImageRest8.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest8.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest8.setOpaque(true);
        healthcareImageRest8.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest9.setBackground(healthcareBackground);
        healthcareImageRest9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest9.setIcon(healthcareImage);
        healthcareImageRest9.setBorder(healthcareBorder);
        healthcareImageRest9.setFocusable(false);
        healthcareImageRest9.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest9.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest9.setOpaque(true);
        healthcareImageRest9.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageRest10.setBackground(healthcareBackground);
        healthcareImageRest10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageRest10.setIcon(healthcareImage);
        healthcareImageRest10.setBorder(healthcareBorder);
        healthcareImageRest10.setFocusable(false);
        healthcareImageRest10.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest10.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageRest10.setOpaque(true);
        healthcareImageRest10.setPreferredSize(new java.awt.Dimension(30, 30));

        auxiliaryImageRest1.setBackground(auxiliaryBackground);
        auxiliaryImageRest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        auxiliaryImageRest1.setIcon(auxiliaryImage);
        auxiliaryImageRest1.setBorder(auxiliaryBorder);
        auxiliaryImageRest1.setFocusable(false);
        auxiliaryImageRest1.setMaximumSize(new java.awt.Dimension(30, 30));
        auxiliaryImageRest1.setMinimumSize(new java.awt.Dimension(30, 30));
        auxiliaryImageRest1.setOpaque(true);
        auxiliaryImageRest1.setPreferredSize(new java.awt.Dimension(30, 30));

        auxiliaryImageRest2.setBackground(auxiliaryBackground);
        auxiliaryImageRest2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        auxiliaryImageRest2.setIcon(auxiliaryImage);
        auxiliaryImageRest2.setBorder(auxiliaryBorder);
        auxiliaryImageRest2.setFocusable(false);
        auxiliaryImageRest2.setMaximumSize(new java.awt.Dimension(30, 30));
        auxiliaryImageRest2.setMinimumSize(new java.awt.Dimension(30, 30));
        auxiliaryImageRest2.setOpaque(true);
        auxiliaryImageRest2.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout restRoomLayout = new javax.swing.GroupLayout(restRoom);
        restRoom.setLayout(restRoomLayout);
        restRoomLayout.setHorizontalGroup(
            restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restRoomLayout.createSequentialGroup()
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restIntWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restExtWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(restRoomLayout.createSequentialGroup()
                                .addComponent(healthcareImageRest9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareImageRest10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(restRoomLayout.createSequentialGroup()
                                .addComponent(healthcareRest10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareRest9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(restRoomLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addComponent(auxiliaryRest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareRest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareRest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addComponent(auxiliaryImageRest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareImageRest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareImageRest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addComponent(healthcareImageRest3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareImageRest4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareImageRest5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addComponent(healthcareRest3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareRest4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareRest5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addComponent(healthcareImageRest6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareImageRest7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareImageRest8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addComponent(healthcareRest6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthcareRest7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(auxiliaryImageRest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareRest8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(auxiliaryRest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        restRoomLayout.setVerticalGroup(
            restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restRoomLayout.createSequentialGroup()
                .addComponent(restIntWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(auxiliaryImageRest1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageRest1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageRest2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auxiliaryRest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareRest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareRest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthcareImageRest3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageRest4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageRest5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(healthcareRest3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareRest4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareRest5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthcareImageRest6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageRest7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageRest8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(healthcareRest6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareRest7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareRest8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(auxiliaryImageRest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageRest10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(restRoomLayout.createSequentialGroup()
                        .addComponent(healthcareImageRest9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(restRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(healthcareRest10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(auxiliaryRest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareRest9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(restExtWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        vaccinationRoom.setBackground(new java.awt.Color(224, 227, 231));
        vaccinationRoom.setFocusable(false);
        vaccinationRoom.setMaximumSize(new java.awt.Dimension(306, 372));
        vaccinationRoom.setMinimumSize(new java.awt.Dimension(306, 372));
        vaccinationRoom.setPreferredSize(new java.awt.Dimension(306, 372));

        patientVaccination1.setBackground(patientBackground);
        patientVaccination1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination1.setText("0000");
        patientVaccination1.setBorder(patientBorder);
        patientVaccination1.setFocusable(false);
        patientVaccination1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination1.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination1.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination1.setOpaque(true);
        patientVaccination1.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination2.setBackground(patientBackground);
        patientVaccination2.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination2.setText("0000");
        patientVaccination2.setBorder(patientBorder);
        patientVaccination2.setFocusable(false);
        patientVaccination2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination2.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination2.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination2.setOpaque(true);
        patientVaccination2.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination3.setBackground(patientBackground);
        patientVaccination3.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination3.setText("0000");
        patientVaccination3.setBorder(patientBorder);
        patientVaccination3.setFocusable(false);
        patientVaccination3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination3.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination3.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination3.setOpaque(true);
        patientVaccination3.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination4.setBackground(patientBackground);
        patientVaccination4.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination4.setText("0000");
        patientVaccination4.setBorder(patientBorder);
        patientVaccination4.setFocusable(false);
        patientVaccination4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination4.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination4.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination4.setOpaque(true);
        patientVaccination4.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination5.setBackground(patientBackground);
        patientVaccination5.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination5.setText("0000");
        patientVaccination5.setBorder(patientBorder);
        patientVaccination5.setFocusable(false);
        patientVaccination5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination5.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination5.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination5.setOpaque(true);
        patientVaccination5.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination6.setBackground(patientBackground);
        patientVaccination6.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination6.setText("0000");
        patientVaccination6.setBorder(patientBorder);
        patientVaccination6.setFocusable(false);
        patientVaccination6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination6.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination6.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination6.setOpaque(true);
        patientVaccination6.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination7.setBackground(patientBackground);
        patientVaccination7.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination7.setText("0000");
        patientVaccination7.setBorder(patientBorder);
        patientVaccination7.setFocusable(false);
        patientVaccination7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination7.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination7.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination7.setOpaque(true);
        patientVaccination7.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination8.setBackground(patientBackground);
        patientVaccination8.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination8.setText("0000");
        patientVaccination8.setBorder(patientBorder);
        patientVaccination8.setFocusable(false);
        patientVaccination8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination8.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination8.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination8.setOpaque(true);
        patientVaccination8.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination9.setBackground(patientBackground);
        patientVaccination9.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination9.setText("0000");
        patientVaccination9.setBorder(patientBorder);
        patientVaccination9.setFocusable(false);
        patientVaccination9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination9.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination9.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination9.setOpaque(true);
        patientVaccination9.setPreferredSize(new java.awt.Dimension(30, 20));

        patientVaccination10.setBackground(patientBackground);
        patientVaccination10.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        patientVaccination10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientVaccination10.setText("0000");
        patientVaccination10.setBorder(patientBorder);
        patientVaccination10.setFocusable(false);
        patientVaccination10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientVaccination10.setMaximumSize(new java.awt.Dimension(30, 20));
        patientVaccination10.setMinimumSize(new java.awt.Dimension(30, 20));
        patientVaccination10.setOpaque(true);
        patientVaccination10.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination1.setBackground(healthcareBackground);
        healthcareVaccination1.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination1.setText("00");
        healthcareVaccination1.setBorder(healthcareBorder);
        healthcareVaccination1.setFocusable(false);
        healthcareVaccination1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination1.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination1.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination1.setOpaque(true);
        healthcareVaccination1.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination2.setBackground(healthcareBackground);
        healthcareVaccination2.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination2.setText("00");
        healthcareVaccination2.setBorder(healthcareBorder);
        healthcareVaccination2.setFocusable(false);
        healthcareVaccination2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination2.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination2.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination2.setOpaque(true);
        healthcareVaccination2.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination3.setBackground(healthcareBackground);
        healthcareVaccination3.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination3.setText("00");
        healthcareVaccination3.setBorder(healthcareBorder);
        healthcareVaccination3.setFocusable(false);
        healthcareVaccination3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination3.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination3.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination3.setOpaque(true);
        healthcareVaccination3.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination4.setBackground(healthcareBackground);
        healthcareVaccination4.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination4.setText("00");
        healthcareVaccination4.setBorder(healthcareBorder);
        healthcareVaccination4.setFocusable(false);
        healthcareVaccination4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination4.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination4.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination4.setOpaque(true);
        healthcareVaccination4.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination5.setBackground(healthcareBackground);
        healthcareVaccination5.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination5.setText("00");
        healthcareVaccination5.setBorder(healthcareBorder);
        healthcareVaccination5.setFocusable(false);
        healthcareVaccination5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination5.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination5.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination5.setOpaque(true);
        healthcareVaccination5.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination6.setBackground(healthcareBackground);
        healthcareVaccination6.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination6.setText("00");
        healthcareVaccination6.setBorder(healthcareBorder);
        healthcareVaccination6.setFocusable(false);
        healthcareVaccination6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination6.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination6.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination6.setOpaque(true);
        healthcareVaccination6.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination7.setBackground(healthcareBackground);
        healthcareVaccination7.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination7.setText("00");
        healthcareVaccination7.setBorder(healthcareBorder);
        healthcareVaccination7.setFocusable(false);
        healthcareVaccination7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination7.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination7.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination7.setOpaque(true);
        healthcareVaccination7.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination8.setBackground(healthcareBackground);
        healthcareVaccination8.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination8.setText("00");
        healthcareVaccination8.setBorder(healthcareBorder);
        healthcareVaccination8.setFocusable(false);
        healthcareVaccination8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination8.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination8.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination8.setOpaque(true);
        healthcareVaccination8.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination9.setBackground(healthcareBackground);
        healthcareVaccination9.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination9.setText("00");
        healthcareVaccination9.setBorder(healthcareBorder);
        healthcareVaccination9.setFocusable(false);
        healthcareVaccination9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination9.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination9.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination9.setOpaque(true);
        healthcareVaccination9.setPreferredSize(new java.awt.Dimension(30, 20));

        healthcareVaccination10.setBackground(healthcareBackground);
        healthcareVaccination10.setFont(new java.awt.Font("DejaVu Sans", 0, 8)); // NOI18N
        healthcareVaccination10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareVaccination10.setText("00");
        healthcareVaccination10.setBorder(healthcareBorder);
        healthcareVaccination10.setFocusable(false);
        healthcareVaccination10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        healthcareVaccination10.setMaximumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination10.setMinimumSize(new java.awt.Dimension(30, 20));
        healthcareVaccination10.setOpaque(true);
        healthcareVaccination10.setPreferredSize(new java.awt.Dimension(30, 20));

        vaccinationIntWall.setBackground(new java.awt.Color(202, 209, 219));
        vaccinationIntWall.setFont(new java.awt.Font("Linux Biolinum G", 0, 10)); // NOI18N
        vaccinationIntWall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vaccinationIntWall.setText("V A C C I N A T I O N      R O O M");
        vaccinationIntWall.setFocusable(false);
        vaccinationIntWall.setMaximumSize(new java.awt.Dimension(306, 20));
        vaccinationIntWall.setMinimumSize(new java.awt.Dimension(306, 20));
        vaccinationIntWall.setOpaque(true);
        vaccinationIntWall.setPreferredSize(new java.awt.Dimension(306, 20));

        vaccinationExtWall.setBackground(new java.awt.Color(153, 153, 153));
        vaccinationExtWall.setFocusable(false);
        vaccinationExtWall.setMaximumSize(new java.awt.Dimension(306, 20));
        vaccinationExtWall.setMinimumSize(new java.awt.Dimension(306, 20));
        vaccinationExtWall.setOpaque(true);
        vaccinationExtWall.setPreferredSize(new java.awt.Dimension(306, 20));

        healthcareImageVaccination1.setBackground(healthcareBackground);
        healthcareImageVaccination1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination1.setIcon(healthcareImage);
        healthcareImageVaccination1.setBorder(healthcareBorder);
        healthcareImageVaccination1.setFocusable(false);
        healthcareImageVaccination1.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination1.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination1.setOpaque(true);
        healthcareImageVaccination1.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination2.setBackground(healthcareBackground);
        healthcareImageVaccination2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination2.setIcon(healthcareImage);
        healthcareImageVaccination2.setBorder(healthcareBorder);
        healthcareImageVaccination2.setFocusable(false);
        healthcareImageVaccination2.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination2.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination2.setOpaque(true);
        healthcareImageVaccination2.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination3.setBackground(healthcareBackground);
        healthcareImageVaccination3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination3.setIcon(healthcareImage);
        healthcareImageVaccination3.setBorder(healthcareBorder);
        healthcareImageVaccination3.setFocusable(false);
        healthcareImageVaccination3.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination3.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination3.setOpaque(true);
        healthcareImageVaccination3.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination4.setBackground(healthcareBackground);
        healthcareImageVaccination4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination4.setIcon(healthcareImage);
        healthcareImageVaccination4.setBorder(healthcareBorder);
        healthcareImageVaccination4.setFocusable(false);
        healthcareImageVaccination4.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination4.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination4.setOpaque(true);
        healthcareImageVaccination4.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination5.setBackground(healthcareBackground);
        healthcareImageVaccination5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination5.setIcon(healthcareImage);
        healthcareImageVaccination5.setBorder(healthcareBorder);
        healthcareImageVaccination5.setFocusable(false);
        healthcareImageVaccination5.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination5.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination5.setOpaque(true);
        healthcareImageVaccination5.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination6.setBackground(healthcareBackground);
        healthcareImageVaccination6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination6.setIcon(healthcareImage);
        healthcareImageVaccination6.setBorder(healthcareBorder);
        healthcareImageVaccination6.setFocusable(false);
        healthcareImageVaccination6.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination6.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination6.setOpaque(true);
        healthcareImageVaccination6.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination7.setBackground(healthcareBackground);
        healthcareImageVaccination7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination7.setIcon(healthcareImage);
        healthcareImageVaccination7.setBorder(healthcareBorder);
        healthcareImageVaccination7.setFocusable(false);
        healthcareImageVaccination7.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination7.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination7.setOpaque(true);
        healthcareImageVaccination7.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination8.setBackground(healthcareBackground);
        healthcareImageVaccination8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination8.setIcon(healthcareImage);
        healthcareImageVaccination8.setBorder(healthcareBorder);
        healthcareImageVaccination8.setFocusable(false);
        healthcareImageVaccination8.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination8.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination8.setOpaque(true);
        healthcareImageVaccination8.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination9.setBackground(healthcareBackground);
        healthcareImageVaccination9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination9.setIcon(healthcareImage);
        healthcareImageVaccination9.setBorder(healthcareBorder);
        healthcareImageVaccination9.setFocusable(false);
        healthcareImageVaccination9.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination9.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination9.setOpaque(true);
        healthcareImageVaccination9.setPreferredSize(new java.awt.Dimension(30, 30));

        healthcareImageVaccination10.setBackground(healthcareBackground);
        healthcareImageVaccination10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthcareImageVaccination10.setIcon(healthcareImage);
        healthcareImageVaccination10.setBorder(healthcareBorder);
        healthcareImageVaccination10.setFocusable(false);
        healthcareImageVaccination10.setMaximumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination10.setMinimumSize(new java.awt.Dimension(30, 30));
        healthcareImageVaccination10.setOpaque(true);
        healthcareImageVaccination10.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination1.setBackground(patientBackground);
        patientImageVaccination1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination1.setIcon(patientImage);
        patientImageVaccination1.setBorder(patientBorder);
        patientImageVaccination1.setFocusable(false);
        patientImageVaccination1.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination1.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination1.setOpaque(true);
        patientImageVaccination1.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination2.setBackground(patientBackground);
        patientImageVaccination2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination2.setIcon(patientImage);
        patientImageVaccination2.setBorder(patientBorder);
        patientImageVaccination2.setFocusable(false);
        patientImageVaccination2.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination2.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination2.setOpaque(true);
        patientImageVaccination2.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination3.setBackground(patientBackground);
        patientImageVaccination3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination3.setIcon(patientImage);
        patientImageVaccination3.setBorder(patientBorder);
        patientImageVaccination3.setFocusable(false);
        patientImageVaccination3.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination3.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination3.setOpaque(true);
        patientImageVaccination3.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination4.setBackground(patientBackground);
        patientImageVaccination4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination4.setIcon(patientImage);
        patientImageVaccination4.setBorder(patientBorder);
        patientImageVaccination4.setFocusable(false);
        patientImageVaccination4.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination4.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination4.setOpaque(true);
        patientImageVaccination4.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination5.setBackground(patientBackground);
        patientImageVaccination5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination5.setIcon(patientImage);
        patientImageVaccination5.setBorder(patientBorder);
        patientImageVaccination5.setFocusable(false);
        patientImageVaccination5.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination5.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination5.setOpaque(true);
        patientImageVaccination5.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination6.setBackground(patientBackground);
        patientImageVaccination6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination6.setIcon(patientImage);
        patientImageVaccination6.setBorder(patientBorder);
        patientImageVaccination6.setFocusable(false);
        patientImageVaccination6.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination6.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination6.setOpaque(true);
        patientImageVaccination6.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination7.setBackground(patientBackground);
        patientImageVaccination7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination7.setIcon(patientImage);
        patientImageVaccination7.setBorder(patientBorder);
        patientImageVaccination7.setFocusable(false);
        patientImageVaccination7.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination7.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination7.setOpaque(true);
        patientImageVaccination7.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination8.setBackground(patientBackground);
        patientImageVaccination8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination8.setIcon(patientImage);
        patientImageVaccination8.setBorder(patientBorder);
        patientImageVaccination8.setFocusable(false);
        patientImageVaccination8.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination8.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination8.setOpaque(true);
        patientImageVaccination8.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination9.setBackground(patientBackground);
        patientImageVaccination9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination9.setIcon(patientImage);
        patientImageVaccination9.setBorder(patientBorder);
        patientImageVaccination9.setFocusable(false);
        patientImageVaccination9.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination9.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination9.setOpaque(true);
        patientImageVaccination9.setPreferredSize(new java.awt.Dimension(30, 30));

        patientImageVaccination10.setBackground(patientBackground);
        patientImageVaccination10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientImageVaccination10.setIcon(patientImage);
        patientImageVaccination10.setBorder(patientBorder);
        patientImageVaccination10.setFocusable(false);
        patientImageVaccination10.setMaximumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination10.setMinimumSize(new java.awt.Dimension(30, 30));
        patientImageVaccination10.setOpaque(true);
        patientImageVaccination10.setPreferredSize(new java.awt.Dimension(30, 30));

        vaccinesContainer.setBackground(new java.awt.Color(153, 153, 255));
        vaccinesContainer.setIcon(vaccinesContainer0Image);
        vaccinesContainer.setFocusable(false);
        vaccinesContainer.setMaximumSize(new java.awt.Dimension(60, 50));
        vaccinesContainer.setMinimumSize(new java.awt.Dimension(60, 50));
        vaccinesContainer.setOpaque(true);
        vaccinesContainer.setPreferredSize(new java.awt.Dimension(60, 50));
        vaccinesContainer.setRequestFocusEnabled(false);

        vaccinesCounter.setBackground(new java.awt.Color(0, 0, 0));
        vaccinesCounter.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        vaccinesCounter.setForeground(new java.awt.Color(255, 0, 51));
        vaccinesCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vaccinesCounter.setText("<html><center>VAX LEFT<br>100</center></html>");
        vaccinesCounter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 5, true));
        vaccinesCounter.setFocusable(false);
        vaccinesCounter.setMaximumSize(new java.awt.Dimension(60, 50));
        vaccinesCounter.setMinimumSize(new java.awt.Dimension(60, 50));
        vaccinesCounter.setOpaque(true);
        vaccinesCounter.setPreferredSize(new java.awt.Dimension(60, 50));
        vaccinesCounter.setRequestFocusEnabled(false);

        vaccinationCounter.setBackground(new java.awt.Color(153, 153, 255));
        vaccinationCounter.setIcon(vaccinationCounterOpenImage);
        vaccinationCounter.setFocusable(false);
        vaccinationCounter.setMaximumSize(new java.awt.Dimension(60, 95));
        vaccinationCounter.setMinimumSize(new java.awt.Dimension(60, 95));
        vaccinationCounter.setOpaque(true);
        vaccinationCounter.setPreferredSize(new java.awt.Dimension(60, 95));
        vaccinationCounter.setRequestFocusEnabled(false);

        buttonDesk1.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk1.setIcon(deskCloseImage);
        buttonDesk1.setBorder(null);
        buttonDesk1.setBorderPainted(false);
        buttonDesk1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk1.setFocusPainted(false);
        buttonDesk1.setFocusable(false);
        buttonDesk1.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk1.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk1.setOpaque(false);
        buttonDesk1.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk1ActionPerformed(evt);
            }
        });

        buttonDesk2.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk2.setIcon(deskCloseImage);
        buttonDesk2.setBorder(null);
        buttonDesk2.setBorderPainted(false);
        buttonDesk2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk2.setFocusPainted(false);
        buttonDesk2.setFocusable(false);
        buttonDesk2.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk2.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk2.setOpaque(false);
        buttonDesk2.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk2ActionPerformed(evt);
            }
        });

        buttonDesk3.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk3.setIcon(deskCloseImage);
        buttonDesk3.setBorder(null);
        buttonDesk3.setBorderPainted(false);
        buttonDesk3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk3.setFocusPainted(false);
        buttonDesk3.setFocusable(false);
        buttonDesk3.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk3.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk3.setOpaque(false);
        buttonDesk3.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk3ActionPerformed(evt);
            }
        });

        buttonDesk4.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk4.setIcon(deskCloseImage);
        buttonDesk4.setBorder(null);
        buttonDesk4.setBorderPainted(false);
        buttonDesk4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk4.setFocusPainted(false);
        buttonDesk4.setFocusable(false);
        buttonDesk4.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk4.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk4.setOpaque(false);
        buttonDesk4.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk4ActionPerformed(evt);
            }
        });

        buttonDesk5.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk5.setIcon(deskCloseImage);
        buttonDesk5.setBorder(null);
        buttonDesk5.setBorderPainted(false);
        buttonDesk5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk5.setFocusPainted(false);
        buttonDesk5.setFocusable(false);
        buttonDesk5.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk5.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk5.setOpaque(false);
        buttonDesk5.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk5ActionPerformed(evt);
            }
        });

        buttonDesk6.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk6.setIcon(deskCloseImage);
        buttonDesk6.setBorder(null);
        buttonDesk6.setBorderPainted(false);
        buttonDesk6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk6.setFocusPainted(false);
        buttonDesk6.setFocusable(false);
        buttonDesk6.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk6.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk6.setOpaque(false);
        buttonDesk6.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk6ActionPerformed(evt);
            }
        });

        buttonDesk7.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk7.setIcon(deskCloseImage);
        buttonDesk7.setBorder(null);
        buttonDesk7.setBorderPainted(false);
        buttonDesk7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk7.setFocusPainted(false);
        buttonDesk7.setFocusable(false);
        buttonDesk7.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk7.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk7.setOpaque(false);
        buttonDesk7.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk7ActionPerformed(evt);
            }
        });

        buttonDesk8.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk8.setIcon(deskCloseImage);
        buttonDesk8.setBorder(null);
        buttonDesk8.setBorderPainted(false);
        buttonDesk8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk8.setFocusPainted(false);
        buttonDesk8.setFocusable(false);
        buttonDesk8.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk8.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk8.setOpaque(false);
        buttonDesk8.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk8ActionPerformed(evt);
            }
        });

        buttonDesk10.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk10.setIcon(deskCloseImage);
        buttonDesk10.setBorder(null);
        buttonDesk10.setBorderPainted(false);
        buttonDesk10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk10.setFocusPainted(false);
        buttonDesk10.setFocusable(false);
        buttonDesk10.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk10.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk10.setOpaque(false);
        buttonDesk10.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk10ActionPerformed(evt);
            }
        });

        buttonDesk9.setBackground(new java.awt.Color(224, 227, 231));
        buttonDesk9.setIcon(deskCloseImage);
        buttonDesk9.setBorder(null);
        buttonDesk9.setBorderPainted(false);
        buttonDesk9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonDesk9.setFocusPainted(false);
        buttonDesk9.setFocusable(false);
        buttonDesk9.setMaximumSize(new java.awt.Dimension(35, 35));
        buttonDesk9.setMinimumSize(new java.awt.Dimension(35, 35));
        buttonDesk9.setOpaque(false);
        buttonDesk9.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonDesk9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesk9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vaccinationRoomLayout = new javax.swing.GroupLayout(vaccinationRoom);
        vaccinationRoom.setLayout(vaccinationRoomLayout);
        vaccinationRoomLayout.setHorizontalGroup(
            vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(patientVaccination6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientImageVaccination6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(patientImageVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vaccinationRoomLayout.createSequentialGroup()
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(healthcareImageVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonDesk7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonDesk8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(vaccinationCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonDesk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonDesk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientImageVaccination2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(patientVaccination2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(patientImageVaccination3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(healthcareImageVaccination6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareVaccination6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(buttonDesk6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(vaccinesCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDesk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientVaccination1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageVaccination1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                .addComponent(patientVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(healthcareVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(patientVaccination9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientImageVaccination9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(healthcareImageVaccination9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(healthcareVaccination9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addComponent(buttonDesk9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(patientImageVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(healthcareImageVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(healthcareVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addComponent(buttonDesk10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(vaccinesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonDesk4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonDesk5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientVaccination4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageVaccination5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientVaccination5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientImageVaccination4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientVaccination3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(healthcareVaccination2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(healthcareVaccination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(healthcareImageVaccination2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(healthcareImageVaccination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(healthcareVaccination3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageVaccination4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareVaccination4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageVaccination5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareVaccination5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthcareImageVaccination3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vaccinationExtWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vaccinationIntWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        vaccinationRoomLayout.setVerticalGroup(
            vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                .addComponent(vaccinationIntWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientImageVaccination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthcareImageVaccination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(healthcareImageVaccination6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientImageVaccination6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(patientImageVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(healthcareImageVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(healthcareVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientVaccination7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(healthcareImageVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientImageVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vaccinationRoomLayout.createSequentialGroup()
                                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(healthcareVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(patientVaccination8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                                        .addComponent(patientImageVaccination9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(patientVaccination9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                                            .addGap(30, 30, 30)
                                                            .addComponent(healthcareVaccination9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(healthcareImageVaccination9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(buttonDesk9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                                        .addComponent(patientImageVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(20, 20, 20))
                                                    .addComponent(patientVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                                        .addComponent(healthcareImageVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(healthcareVaccination10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(patientVaccination3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(healthcareVaccination3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(healthcareImageVaccination4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(patientImageVaccination4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(healthcareVaccination4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(patientVaccination4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(patientImageVaccination5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(buttonDesk5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                                            .addComponent(healthcareImageVaccination5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(0, 0, 0)
                                                            .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(healthcareVaccination5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(patientVaccination5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vaccinationRoomLayout.createSequentialGroup()
                                                .addComponent(buttonDesk4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60))))
                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                        .addComponent(vaccinationCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(vaccinesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))
                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                        .addComponent(buttonDesk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120))
                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                        .addComponent(buttonDesk8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85)
                                        .addComponent(buttonDesk10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonDesk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(vaccinationRoomLayout.createSequentialGroup()
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(patientVaccination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(healthcareVaccination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientVaccination6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(healthcareVaccination6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(healthcareImageVaccination2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientImageVaccination2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(healthcareVaccination2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(patientVaccination2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(healthcareImageVaccination3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(patientImageVaccination3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vaccinationRoomLayout.createSequentialGroup()
                                .addComponent(buttonDesk7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180))))
                    .addGroup(vaccinationRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonDesk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vaccinesCounter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDesk6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vaccinationExtWall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(restRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(observationRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vaccinationRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(receptionRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(receptionRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(observationRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vaccinationRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1014, 667));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon("src/main/java/IconImages/virus.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        LogIn logIn = new LogIn(this);
    }//GEN-LAST:event_backButtonActionPerformed

    private void buttonDesk9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk9ActionPerformed
        buttonDesksActionPerfomed(8);
    }//GEN-LAST:event_buttonDesk9ActionPerformed

    private void buttonDesk10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk10ActionPerformed
        buttonDesksActionPerfomed(9);
    }//GEN-LAST:event_buttonDesk10ActionPerformed

    private void buttonDesk8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk8ActionPerformed
        buttonDesksActionPerfomed(7);
    }//GEN-LAST:event_buttonDesk8ActionPerformed

    private void buttonDesk7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk7ActionPerformed
        buttonDesksActionPerfomed(6);
    }//GEN-LAST:event_buttonDesk7ActionPerformed

    private void buttonDesk6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk6ActionPerformed
        buttonDesksActionPerfomed(5);
    }//GEN-LAST:event_buttonDesk6ActionPerformed

    private void buttonDesk5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk5ActionPerformed
        buttonDesksActionPerfomed(4);
    }//GEN-LAST:event_buttonDesk5ActionPerformed

    private void buttonDesk4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk4ActionPerformed
        buttonDesksActionPerfomed(3);
    }//GEN-LAST:event_buttonDesk4ActionPerformed

    private void buttonDesk3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk3ActionPerformed
        buttonDesksActionPerfomed(2);
    }//GEN-LAST:event_buttonDesk3ActionPerformed

    private void buttonDesk2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk2ActionPerformed
        buttonDesksActionPerfomed(1);
    }//GEN-LAST:event_buttonDesk2ActionPerformed

    private void buttonDesk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesk1ActionPerformed
        buttonDesksActionPerfomed(0);
    }//GEN-LAST:event_buttonDesk1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel auxiliaryImageRest1;
    private javax.swing.JLabel auxiliaryImageRest2;
    private javax.swing.JLabel auxiliaryRest1;
    private javax.swing.JLabel auxiliaryRest2;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton buttonDesk1;
    private javax.swing.JButton buttonDesk10;
    private javax.swing.JButton buttonDesk2;
    private javax.swing.JButton buttonDesk3;
    private javax.swing.JButton buttonDesk4;
    private javax.swing.JButton buttonDesk5;
    private javax.swing.JButton buttonDesk6;
    private javax.swing.JButton buttonDesk7;
    private javax.swing.JButton buttonDesk8;
    private javax.swing.JButton buttonDesk9;
    private javax.swing.JLabel healthcareImageObservation1;
    private javax.swing.JLabel healthcareImageObservation10;
    private javax.swing.JLabel healthcareImageObservation11;
    private javax.swing.JLabel healthcareImageObservation12;
    private javax.swing.JLabel healthcareImageObservation13;
    private javax.swing.JLabel healthcareImageObservation14;
    private javax.swing.JLabel healthcareImageObservation15;
    private javax.swing.JLabel healthcareImageObservation16;
    private javax.swing.JLabel healthcareImageObservation17;
    private javax.swing.JLabel healthcareImageObservation18;
    private javax.swing.JLabel healthcareImageObservation19;
    private javax.swing.JLabel healthcareImageObservation2;
    private javax.swing.JLabel healthcareImageObservation20;
    private javax.swing.JLabel healthcareImageObservation3;
    private javax.swing.JLabel healthcareImageObservation4;
    private javax.swing.JLabel healthcareImageObservation5;
    private javax.swing.JLabel healthcareImageObservation6;
    private javax.swing.JLabel healthcareImageObservation7;
    private javax.swing.JLabel healthcareImageObservation8;
    private javax.swing.JLabel healthcareImageObservation9;
    private javax.swing.JLabel healthcareImageRest1;
    private javax.swing.JLabel healthcareImageRest10;
    private javax.swing.JLabel healthcareImageRest2;
    private javax.swing.JLabel healthcareImageRest3;
    private javax.swing.JLabel healthcareImageRest4;
    private javax.swing.JLabel healthcareImageRest5;
    private javax.swing.JLabel healthcareImageRest6;
    private javax.swing.JLabel healthcareImageRest7;
    private javax.swing.JLabel healthcareImageRest8;
    private javax.swing.JLabel healthcareImageRest9;
    private javax.swing.JLabel healthcareImageVaccination1;
    private javax.swing.JLabel healthcareImageVaccination10;
    private javax.swing.JLabel healthcareImageVaccination2;
    private javax.swing.JLabel healthcareImageVaccination3;
    private javax.swing.JLabel healthcareImageVaccination4;
    private javax.swing.JLabel healthcareImageVaccination5;
    private javax.swing.JLabel healthcareImageVaccination6;
    private javax.swing.JLabel healthcareImageVaccination7;
    private javax.swing.JLabel healthcareImageVaccination8;
    private javax.swing.JLabel healthcareImageVaccination9;
    private javax.swing.JLabel healthcareObservation1;
    private javax.swing.JLabel healthcareObservation10;
    private javax.swing.JLabel healthcareObservation11;
    private javax.swing.JLabel healthcareObservation12;
    private javax.swing.JLabel healthcareObservation13;
    private javax.swing.JLabel healthcareObservation14;
    private javax.swing.JLabel healthcareObservation15;
    private javax.swing.JLabel healthcareObservation16;
    private javax.swing.JLabel healthcareObservation17;
    private javax.swing.JLabel healthcareObservation18;
    private javax.swing.JLabel healthcareObservation19;
    private javax.swing.JLabel healthcareObservation2;
    private javax.swing.JLabel healthcareObservation20;
    private javax.swing.JLabel healthcareObservation3;
    private javax.swing.JLabel healthcareObservation4;
    private javax.swing.JLabel healthcareObservation5;
    private javax.swing.JLabel healthcareObservation6;
    private javax.swing.JLabel healthcareObservation7;
    private javax.swing.JLabel healthcareObservation8;
    private javax.swing.JLabel healthcareObservation9;
    private javax.swing.JLabel healthcareRest1;
    private javax.swing.JLabel healthcareRest10;
    private javax.swing.JLabel healthcareRest2;
    private javax.swing.JLabel healthcareRest3;
    private javax.swing.JLabel healthcareRest4;
    private javax.swing.JLabel healthcareRest5;
    private javax.swing.JLabel healthcareRest6;
    private javax.swing.JLabel healthcareRest7;
    private javax.swing.JLabel healthcareRest8;
    private javax.swing.JLabel healthcareRest9;
    private javax.swing.JLabel healthcareVaccination1;
    private javax.swing.JLabel healthcareVaccination10;
    private javax.swing.JLabel healthcareVaccination2;
    private javax.swing.JLabel healthcareVaccination3;
    private javax.swing.JLabel healthcareVaccination4;
    private javax.swing.JLabel healthcareVaccination5;
    private javax.swing.JLabel healthcareVaccination6;
    private javax.swing.JLabel healthcareVaccination7;
    private javax.swing.JLabel healthcareVaccination8;
    private javax.swing.JLabel healthcareVaccination9;
    private javax.swing.JLabel observationExtWall;
    private javax.swing.JLabel observationIntWall;
    private javax.swing.JPanel observationRoom;
    private javax.swing.JLabel patientChecked;
    private javax.swing.JLabel patientImageObservation1;
    private javax.swing.JLabel patientImageObservation10;
    private javax.swing.JLabel patientImageObservation11;
    private javax.swing.JLabel patientImageObservation12;
    private javax.swing.JLabel patientImageObservation13;
    private javax.swing.JLabel patientImageObservation14;
    private javax.swing.JLabel patientImageObservation15;
    private javax.swing.JLabel patientImageObservation16;
    private javax.swing.JLabel patientImageObservation17;
    private javax.swing.JLabel patientImageObservation18;
    private javax.swing.JLabel patientImageObservation19;
    private javax.swing.JLabel patientImageObservation2;
    private javax.swing.JLabel patientImageObservation20;
    private javax.swing.JLabel patientImageObservation3;
    private javax.swing.JLabel patientImageObservation4;
    private javax.swing.JLabel patientImageObservation5;
    private javax.swing.JLabel patientImageObservation6;
    private javax.swing.JLabel patientImageObservation7;
    private javax.swing.JLabel patientImageObservation8;
    private javax.swing.JLabel patientImageObservation9;
    private javax.swing.JLabel patientImageReception1;
    private javax.swing.JLabel patientImageReception10;
    private javax.swing.JLabel patientImageReception11;
    private javax.swing.JLabel patientImageReception12;
    private javax.swing.JLabel patientImageReception13;
    private javax.swing.JLabel patientImageReception14;
    private javax.swing.JLabel patientImageReception15;
    private javax.swing.JLabel patientImageReception16;
    private javax.swing.JLabel patientImageReception17;
    private javax.swing.JLabel patientImageReception18;
    private javax.swing.JLabel patientImageReception19;
    private javax.swing.JLabel patientImageReception2;
    private javax.swing.JLabel patientImageReception20;
    private javax.swing.JLabel patientImageReception21;
    private javax.swing.JLabel patientImageReception22;
    private javax.swing.JLabel patientImageReception3;
    private javax.swing.JLabel patientImageReception35;
    private javax.swing.JLabel patientImageReception4;
    private javax.swing.JLabel patientImageReception5;
    private javax.swing.JLabel patientImageReception6;
    private javax.swing.JLabel patientImageReception7;
    private javax.swing.JLabel patientImageReception8;
    private javax.swing.JLabel patientImageReception9;
    private javax.swing.JLabel patientImageVaccination1;
    private javax.swing.JLabel patientImageVaccination10;
    private javax.swing.JLabel patientImageVaccination2;
    private javax.swing.JLabel patientImageVaccination3;
    private javax.swing.JLabel patientImageVaccination4;
    private javax.swing.JLabel patientImageVaccination5;
    private javax.swing.JLabel patientImageVaccination6;
    private javax.swing.JLabel patientImageVaccination7;
    private javax.swing.JLabel patientImageVaccination8;
    private javax.swing.JLabel patientImageVaccination9;
    private javax.swing.JLabel patientObservation1;
    private javax.swing.JLabel patientObservation10;
    private javax.swing.JLabel patientObservation11;
    private javax.swing.JLabel patientObservation12;
    private javax.swing.JLabel patientObservation13;
    private javax.swing.JLabel patientObservation14;
    private javax.swing.JLabel patientObservation15;
    private javax.swing.JLabel patientObservation16;
    private javax.swing.JLabel patientObservation17;
    private javax.swing.JLabel patientObservation18;
    private javax.swing.JLabel patientObservation19;
    private javax.swing.JLabel patientObservation2;
    private javax.swing.JLabel patientObservation20;
    private javax.swing.JLabel patientObservation3;
    private javax.swing.JLabel patientObservation4;
    private javax.swing.JLabel patientObservation5;
    private javax.swing.JLabel patientObservation6;
    private javax.swing.JLabel patientObservation7;
    private javax.swing.JLabel patientObservation8;
    private javax.swing.JLabel patientObservation9;
    private javax.swing.JLabel patientReception1;
    private javax.swing.JLabel patientReception10;
    private javax.swing.JLabel patientReception11;
    private javax.swing.JLabel patientReception12;
    private javax.swing.JLabel patientReception13;
    private javax.swing.JLabel patientReception14;
    private javax.swing.JLabel patientReception15;
    private javax.swing.JLabel patientReception16;
    private javax.swing.JLabel patientReception17;
    private javax.swing.JLabel patientReception18;
    private javax.swing.JLabel patientReception19;
    private javax.swing.JLabel patientReception2;
    private javax.swing.JLabel patientReception20;
    private javax.swing.JLabel patientReception21;
    private javax.swing.JLabel patientReception22;
    private javax.swing.JLabel patientReception3;
    private javax.swing.JLabel patientReception4;
    private javax.swing.JLabel patientReception5;
    private javax.swing.JLabel patientReception6;
    private javax.swing.JLabel patientReception7;
    private javax.swing.JLabel patientReception8;
    private javax.swing.JLabel patientReception9;
    private javax.swing.JLabel patientVaccination1;
    private javax.swing.JLabel patientVaccination10;
    private javax.swing.JLabel patientVaccination2;
    private javax.swing.JLabel patientVaccination3;
    private javax.swing.JLabel patientVaccination4;
    private javax.swing.JLabel patientVaccination5;
    private javax.swing.JLabel patientVaccination6;
    private javax.swing.JLabel patientVaccination7;
    private javax.swing.JLabel patientVaccination8;
    private javax.swing.JLabel patientVaccination9;
    private javax.swing.JLabel receptionCounter;
    private javax.swing.JLabel receptionExtWall;
    private javax.swing.JLabel receptionIntWall;
    private javax.swing.JPanel receptionRoom;
    private javax.swing.JLabel restExtWall;
    private javax.swing.JLabel restIntWall;
    private javax.swing.JPanel restRoom;
    private javax.swing.JLabel title;
    private javax.swing.JLabel vaccinationCounter;
    private javax.swing.JLabel vaccinationExtWall;
    private javax.swing.JLabel vaccinationIntWall;
    private javax.swing.JPanel vaccinationRoom;
    private javax.swing.JLabel vaccinesContainer;
    private javax.swing.JLabel vaccinesCounter;
    // End of variables declaration//GEN-END:variables
}
