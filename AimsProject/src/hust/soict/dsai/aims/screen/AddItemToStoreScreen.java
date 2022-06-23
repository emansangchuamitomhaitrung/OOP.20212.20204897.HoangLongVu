package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;
    protected JButton addButton;
    protected JDialog addSuccessDialog;

    protected static String screenName;
    protected static String titleName;
    protected static String buttonName;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle(screenName);
        int[] frameSize = (new StoreManagerScreen(store)).getFrameSize();
        setSize(frameSize[0], frameSize[1]);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel tfPanel = new JPanel();
        tfPanel.setLayout(new GridLayout(3, 2, 3, 3));
        tfPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        tfTitle = new JTextField(10);
        tfCost = new JTextField(10);
        tfCategory = new JTextField(10);

        tfPanel.add(new JLabel("Title "));
        tfPanel.add(tfTitle);
        tfPanel.add(new JLabel("Cost "));
        tfPanel.add(tfCost);
        tfPanel.add(new JLabel("Category "));
        tfPanel.add(tfCategory);

        // mainPanel and its components
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Font font = new Font("MS Sans Serif", Font.BOLD, 15);
        JLabel tfTitleDisplay = new JLabel(titleName);

        tfTitleDisplay.setFont(font);
        tfTitleDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton = new JButton(buttonName);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonListener btnListener = new ButtonListener();
        addButton.addActionListener(btnListener);
        addSuccessDialog = new JDialog(this);

        mainPanel.add(tfTitleDisplay);
        mainPanel.add(tfPanel);
        mainPanel.add(addButton);

        return mainPanel;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        menu.add(viewStore);
        viewStore.addActionListener(new ViewStoreListener());

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(new SwitchToAddBookListener());

        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(new SwitchToAddCDListener());

        JMenuItem addDVD= new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(new SwitchToAddDVDListener());

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    protected class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            String mediaTitle = tfTitle.getText();
            String mediaCategory = tfCategory.getText();
            float mediaCost = Float.parseFloat(tfCost.getText());

            switch (button) {
                case "Add book":
                    addSuccessDialog.add(new JLabel("Book " + mediaTitle + " added successfully!"));
                    store.addMedia(new Book(mediaTitle, mediaCategory, mediaCost));
                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfCost.setText("");
                    break;
                case "Add CD":
                    addSuccessDialog.add(new JLabel("CD " + mediaTitle + " added successfully!"));
                    store.addMedia(new CompactDisc(mediaTitle, mediaCategory, mediaCost));
                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfCost.setText("");
                    break;
                case "Add DVD":
                    addSuccessDialog.add(new JLabel("DVD " + mediaTitle + " added successfully!"));
                    store.addMedia(new DigitalVideoDisc(mediaTitle, mediaCategory, mediaCost));
                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfCost.setText("");
                    break;
            }
        }
    }

    protected class ViewStoreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new StoreManagerScreen(store);
        }
    }

    protected class SwitchToAddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddBookToStoreScreen(store);
        }
    }

    protected class SwitchToAddCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        }
    }

    protected class SwitchToAddDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        }
    }

}
