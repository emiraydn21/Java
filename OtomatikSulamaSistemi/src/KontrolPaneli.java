
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.Timer;
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author emira
 */
public class KontrolPaneli extends javax.swing.JFrame {

    /**
     * Creates new form KontrolPaneli
     */
    private Timer textTimer;
    private Timer hideTimer;
    private String labelText = "Designed By Emir AYDIN";
    private int currentIndex = 0;
    String selectedDays;
    int startHour;
    int startMinute;
    int endHour;
    int endMinute;

    private Timer remainingTimeTimer;

    // Kalan süreyi hesaplamak için bu yöntemi ekliyoruz.
    private void updateRemainingTime() {
        // Şuan ki saat
        LocalTime currentTime = LocalTime.now();

        // Kaydedilen program ayarlarına göre programın başlama zamanını alın
        LocalTime programStartTime = LocalTime.of(startHour, startMinute);

        // Kalan süreyi saniye olarak hesaplıyoruz
        long remainingSeconds = currentTime.until(programStartTime, java.time.temporal.ChronoUnit.SECONDS);

        // Program başlangıç ​​zamanının geçmişte olması durumunu ele alın
        if (remainingSeconds < 0) {

            remainingSeconds += 24 * 3600;
        }
        // Kalan süreyi saat, dakika ve saniyeye dönüştürün
        long remainingHours = remainingSeconds / 3600;
        long remainingMinutes = (remainingSeconds % 3600) / 60;
        remainingSeconds %= 60;

        // Etiketi kalan süre ile güncelleyin
        jLabel8.setText("<html><b>Programın Başlamasına:</b> "
                + remainingHours + " Saat, "
                + remainingMinutes + " Dakika, "
                + remainingSeconds + " Saniye" + " Kaldı<html>");
        remainingTimeTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRemainingTime();
            }
        });

    }

    public KontrolPaneli() {
        initComponents();

        //Emir AYDIN Yazısı sürekli harf harf ekrana yazdırılsın.
        textTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Görüntülenecek daha fazla karakter olup olmadığını kontrol edin
                if (currentIndex < labelText.length()) {
                    // Sonraki karakteri etiket metnine ekle
                    jLabel6.setText(jLabel6.getText() + labelText.charAt(currentIndex));
                    currentIndex++;
                } else {
                    // Metin zamanlayıcısını durdurun ve gizleme zamanlayıcısını başlatın
                    textTimer.stop();
                    hideTimer.start();
                }
            }
        });
        //Emir AYDIN Yazısı sürekli harf harf ekrana yazdırıldıktan sonra
        //1 saniye bekleyip tekrar yazdırsın.
        hideTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Etiket metnini temizleyin ve dizini sıfırlayın
                jLabel6.setText("");
                currentIndex = 0;

                // Gizleme zamanlayıcısını durdurun ve metin zamanlayıcısını yeniden başlatın
                hideTimer.stop();
                textTimer.start();
            }
        });

        // Metin zamanlayıcının başlangıç ​​gecikmesini ayarlayın
        textTimer.setInitialDelay(0);
        // Metin zamanlayıcısını başlat
        textTimer.start();
        // SimpleDateFormat nesnesi oluştur
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        // Mevcut tarih ve saati formatla
        String currentTime = dateFormat.format(new Date());

        // jLabel1 etiketinin metnini güncelle
        jLabel1.setText(currentTime);

        timer.start();

        jLabel2.setText(" " + " Durum " + "=" + " Pasif ");
        jLabel5.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel7.setVisible(false);
        pazartesi.setVisible(false);
        sali.setVisible(false);
        carsamba.setVisible(false);
        persembe.setVisible(false);
        cuma.setVisible(false);
        cumartesi.setVisible(false);
        pazar.setVisible(false);
        jSpinner1.setVisible(false);
        jSpinner2.setVisible(false);
        jSpinner3.setVisible(false);
        jSpinner4.setVisible(false);
        kaydet.setVisible(false);
        jLabel8.setVisible(false);
        try ( BufferedReader reader = new BufferedReader(new FileReader("veriler.txt"))) {
            selectedDays = reader.readLine();
            startHour = Integer.parseInt(reader.readLine());
            startMinute = Integer.parseInt(reader.readLine());
            endHour = Integer.parseInt(reader.readLine());
            endMinute = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Okunan verileri kullanma
        System.out.println("Günler: " + selectedDays + "/n");
        System.out.println("Başlangıç Saati: " + startHour + ":" + startMinute);
        System.out.println("Bitiş Saati: " + endHour + ":" + endMinute);

    }

    // Güncel Saat ve Tarih Bilgisi
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String currentTime = dateFormat.format(new Date());
            jLabel1.setText(currentTime);
            updateRemainingTime();
        }

    });

    private boolean systemStarted = false;
//Butonun Başlat ve Durdur Özelliği   

    private void updateStatusLabel() {
        if (systemStarted) {
            jLabel2.setText(" Durum = Aktif ");
            baslat_durdur.setText("DURDUR");
            baslat_durdur.setBackground(Color.RED);  // Set background color to red for "DURDUR" state

        } else {
            jLabel2.setText(" Durum = Pasif ");
            baslat_durdur.setText("BAŞLAT");
            baslat_durdur.setBackground(new java.awt.Color(102, 255, 0));  // Set original background color
        }
    }

    // ... (existing code)
    /**
     * Bu yöntem, formu başlatmak için yapıcının içinden çağrılır. UYARI: Bu
     * kodu DEĞİŞTİRMEYİN. Bu yöntemin içeriği her zaman Form Düzenleyici
     * tarafından yeniden oluşturuldu.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ayarlar = new javax.swing.JButton();
        programlar = new javax.swing.JButton();
        baslat_durdur = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pazartesi = new javax.swing.JCheckBox();
        sali = new javax.swing.JCheckBox();
        carsamba = new javax.swing.JCheckBox();
        persembe = new javax.swing.JCheckBox();
        cuma = new javax.swing.JCheckBox();
        cumartesi = new javax.swing.JCheckBox();
        pazar = new javax.swing.JCheckBox();
        kaydet = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        acık_koyu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OTOMATİK SULAMA SİSTEMİ KONTROL PANELİ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tarih ve Saat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ayarlar.setBackground(new java.awt.Color(0, 255, 255));
        ayarlar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ayarlar.setText("AYARLAR");
        ayarlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayarlarActionPerformed(evt);
            }
        });

        programlar.setBackground(new java.awt.Color(102, 0, 204));
        programlar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        programlar.setText("PROGRAMLAR");
        programlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programlarActionPerformed(evt);
            }
        });

        baslat_durdur.setBackground(new java.awt.Color(102, 255, 0));
        baslat_durdur.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        baslat_durdur.setText("BAŞLAT");
        baslat_durdur.setToolTipText("");
        baslat_durdur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baslat_durdurActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jSpinner1.setBorder(javax.swing.BorderFactory.createTitledBorder("Saat"));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jSpinner2.setToolTipText("");
        jSpinner2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dakika"));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Program Başlangıç Zamanı");

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jSpinner3.setBorder(javax.swing.BorderFactory.createTitledBorder("Saat"));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jSpinner4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dakika"));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("    Program Bitiş Zamanı");

        jLabel5.setText("GÜNLER");

        pazartesi.setText("Pazartesi");

        sali.setText("Salı");

        carsamba.setText("Çarşamba");

        persembe.setText("Perşembe");

        cuma.setText("Cuma");

        cumartesi.setText("Cumartesi");

        pazar.setText("Pazar");

        kaydet.setBackground(new java.awt.Color(255, 0, 51));
        kaydet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        kaydet.setText("KAYDET");
        kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydetActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel7.setText(" ");

        jLabel8.setText(" ");

        acık_koyu.setText("KOYU TEMA");
        acık_koyu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acık_koyuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sali, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pazartesi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carsamba, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(persembe, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuma, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cumartesi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pazar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(kaydet))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ayarlar)
                                .addGap(45, 45, 45)
                                .addComponent(programlar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(baslat_durdur)
                                .addGap(117, 117, 117))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(acık_koyu))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(acık_koyu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ayarlar)
                    .addComponent(programlar)
                    .addComponent(baslat_durdur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pazartesi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carsamba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(persembe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cumartesi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pazar)
                .addGap(32, 32, 32)
                .addComponent(kaydet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jSpinner1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void baslat_durdurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baslat_durdurActionPerformed
        // TODO add your handling code here:
        systemStarted = !systemStarted;  // Sistem durumunu değiştir
        updateStatusLabel();

        if (systemStarted) {
            remainingTimeTimer.start();
            jLabel8.setVisible(true);
            jLabel8.setText(""); // Sistem durdurulduğunda kalan süre etiketini temizle

        } else {
            remainingTimeTimer.stop();

            jLabel8.setVisible(false);
        }
    }//GEN-LAST:event_baslat_durdurActionPerformed

    private void programlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programlarActionPerformed
        // TODO add your handling code here:

        // jLabel7.setText("Program \n Günler: " + selectedDays
        //       + "\n Başlangıç Saati: " + startHour + ":" + startMinute
        //     + "\n Bitiş Saati: " + endHour + ":" + endMinute);
        String programInfo = "<html><div style='text-align: center;'><b>Program'ım</b></div> "
                + " <b>Günler:</b> " + selectedDays
                + "<br> <b>Başlangıç Saati:</b> " + startHour + ":" + startMinute
                + "<br> <b>Bitiş Saati:</b> " + endHour + ":" + endMinute + "</html>";

        jLabel7.setText(programInfo);

        jLabel5.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        pazartesi.setVisible(false);
        sali.setVisible(false);
        carsamba.setVisible(false);
        persembe.setVisible(false);
        cuma.setVisible(false);
        cumartesi.setVisible(false);
        pazar.setVisible(false);
        jSpinner1.setVisible(false);
        jSpinner2.setVisible(false);
        jSpinner3.setVisible(false);
        jSpinner4.setVisible(false);
        kaydet.setVisible(false);
        jLabel7.setVisible(true);
        jLabel8.setVisible(false);


    }//GEN-LAST:event_programlarActionPerformed

    private void ayarlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayarlarActionPerformed
        // TODO add your handling code here:
        jLabel5.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        pazartesi.setVisible(true);
        sali.setVisible(true);
        carsamba.setVisible(true);
        persembe.setVisible(true);
        cuma.setVisible(true);
        cumartesi.setVisible(true);
        pazar.setVisible(true);
        jSpinner1.setVisible(true);
        jSpinner2.setVisible(true);
        jSpinner3.setVisible(true);
        jSpinner4.setVisible(true);
        kaydet.setVisible(true);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);


    }//GEN-LAST:event_ayarlarActionPerformed

    private void kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydetActionPerformed
        // Günleri Getir
        selectedDays = "";
        if (pazartesi.isSelected()) {
            selectedDays += "Pazartesi, ";
        }
        if (sali.isSelected()) {
            selectedDays += "Salı, ";
        }
        if (carsamba.isSelected()) {
            selectedDays += "Çarşamba, ";
        }
        if (persembe.isSelected()) {
            selectedDays += "Perşembe, ";
        }
        if (cuma.isSelected()) {
            selectedDays += "Cuma, ";
        }
        if (cumartesi.isSelected()) {
            selectedDays += "Cumartesi, ";
        }
        if (pazar.isSelected()) {
            selectedDays += "Pazar, ";
        }

        //Sondaki virgülü ve varsa boşluğu kaldırıyoruz
        if (!selectedDays.isEmpty()) {
            selectedDays = selectedDays.substring(0, selectedDays.length() - 2);
        }

        // Başlangıç ​​ve bitiş zamanlarını al
        startHour = (int) jSpinner1.getValue();
        startMinute = (int) jSpinner2.getValue();
        endHour = (int) jSpinner3.getValue();
        endMinute = (int) jSpinner4.getValue();

        // Seçilen gün ve saatleri konsola yazdırıyoruz
        System.out.println("Selected Days: " + selectedDays);
        System.out.println("Start Time: " + startHour + ":" + startMinute);
        System.out.println("End Time: " + endHour + ":" + endMinute);

        // Bilgileri bir veri yapısında depolamak için bu kısmı daha da değiştirebilirsiniz,
        // onu bir dosyaya kaydedin veya gerekli diğer eylemleri gerçekleştirin.
        jLabel7.setVisible(false);

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("veriler.txt"))) {
            writer.write(selectedDays);
            writer.newLine();
            writer.write(String.valueOf(startHour));
            writer.newLine();
            writer.write(String.valueOf(startMinute));
            writer.newLine();
            writer.write(String.valueOf(endHour));
            writer.newLine();
            writer.write(String.valueOf(endMinute));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_kaydetActionPerformed
    private boolean isDarkMode;
    private Color originalBackgroundColor; // Orijinal arka plan rengini sakla

    private void setTheme() {
        Color backgroundColor, textColor;

        if (originalBackgroundColor == null) {
            originalBackgroundColor = getContentPane().getBackground();
        }

        if (isDarkMode) {
            acık_koyu.setText("KOYU TEMA");
            acık_koyu.setBackground(new java.awt.Color(169, 169, 169));  // Arka plan rengini gri olarak ayarladık

            backgroundColor = originalBackgroundColor;
            textColor = Color.WHITE;
            jPanel1.setBackground(backgroundColor);
            // repaint();
        } else {
            acık_koyu.setText("AÇIK TEMA");
            acık_koyu.setBackground(Color.WHITE);  
            backgroundColor = new Color(205, 183, 158); // Biraz daha koyu açık kahverengi arka plan rengi
            textColor = Color.BLACK;
            jPanel1.setBackground(backgroundColor);
            //repaint();
        }

        // Set background and text colors for your components
        getContentPane().setBackground(backgroundColor);
        //   acık_koyu.setForeground(textColor);

        // Add more components as needed
        // Set the background color of the panel
        // Repaint the frame to reflect the changes
    }

    private void acık_koyuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acık_koyuActionPerformed
        // TODO add your handling code here:
        isDarkMode = !isDarkMode;  // Toggle the system status

        //boolean isDarkMode = acık_koyu.isSelected();
        setTheme();
    }//GEN-LAST:event_acık_koyuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KontrolPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KontrolPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KontrolPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KontrolPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new KontrolPaneli().setVisible(true);
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acık_koyu;
    private javax.swing.JButton ayarlar;
    private javax.swing.JButton baslat_durdur;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox carsamba;
    private javax.swing.JCheckBox cuma;
    private javax.swing.JCheckBox cumartesi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JButton kaydet;
    private javax.swing.JCheckBox pazar;
    private javax.swing.JCheckBox pazartesi;
    private javax.swing.JCheckBox persembe;
    private javax.swing.JButton programlar;
    private javax.swing.JCheckBox sali;
    // End of variables declaration//GEN-END:variables

    private void getValue(JButton kaydet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
