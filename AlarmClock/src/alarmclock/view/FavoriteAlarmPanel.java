/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FavoriteAlarmPanel.java
 *
 * Created on Feb 9, 2012, 11:15:03 PM
 */
package alarmclock.view;

import alarmclock.models.FavoriteAlarm;
import java.util.EventListener;
import java.util.List;

/**
 *
 * @author Gordon
 */
public class FavoriteAlarmPanel extends javax.swing.JPanel {

    private final FavoriteAlarm favorite;
    public FavoriteAlarm getFavorite(){
       return this.favorite;
    }
    
    /** Creates new form FavoriteAlarmPanel */
    public FavoriteAlarmPanel(FavoriteAlarm favorite) {
        this.favorite = favorite;
        
        initComponents();
        
        this.update();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exePath = new javax.swing.JLabel();
        setTime = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        exePath.setText("www.pandora.com");

        setTime.setText("12:00 AM");

        startButton.setText("Start");
        startButton.setPreferredSize(new java.awt.Dimension(63, 20));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setTime, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(setTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exePath)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
     this.fireStartFavorite();
}//GEN-LAST:event_startButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        this.fireRemoveFavorite();
    }//GEN-LAST:event_removeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exePath;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel setTime;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables


    public void update(){
        this.exePath.setText(this.getFavorite().getPath());
        this.setTime.setText(this.getFavorite().getTimeOfDay().toString("h:mm a"));
    }
    
    /*
     * Below is an instance of the Event paradigm.  In java an Event is when you
     * provide methods to add and remove EventListeners.  EventListeners are
     * (usually anonymous) classes which implement a certain interface that 
     * extends from EventListener.  These classes receive Events, which are
     * methods on the interface.
     */
    /**
     * This interface defines an EventListener which receives the events
     * RemoveFavorite and StartFavorite.
     */
    public interface FavoriteAlarmListener extends EventListener{
        /**
         * This event is fired whenever the Remove button is clicked.
         * @param favorite the FavoriteAlarm to remove
         */
        public void RemoveFavorite(FavoriteAlarm favorite);
        
        /**
         * This event is fired whenever the Start button is clicked.
         * @param favorite the FavoriteAlarm to start as an alarm.
         */
        public void StartFavorite(FavoriteAlarm favorite);        
    }
    
    private List<FavoriteAlarmListener> favoriteAlarmListeners = new java.util.ArrayList();
    public void addFavoriteAlarmListener(FavoriteAlarmListener l){
        this.favoriteAlarmListeners.add(l);
    }
    
    public void removeFavoriteAlarmListener(FavoriteAlarmListener l){
        this.favoriteAlarmListeners.remove(l);
    }
    
    private void fireRemoveFavorite(){
        //You should always do this in your Fire methods.  This ensures that 
        //if the event handler removes itself as a listener you will not get an
        //exception when you move on to the next listener.
        FavoriteAlarmListener[] arr = this.favoriteAlarmListeners.toArray(new FavoriteAlarmListener[1]);
        for(FavoriteAlarmListener l : arr){
            l.RemoveFavorite(this.favorite);
        }
    }
    
    private void fireStartFavorite(){
        FavoriteAlarmListener[] arr = this.favoriteAlarmListeners.toArray(new FavoriteAlarmListener[1]);
        for(FavoriteAlarmListener l : this.favoriteAlarmListeners){
            l.StartFavorite(favorite);
        }
    }
}