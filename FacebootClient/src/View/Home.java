/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Faceboot.App;
import Faceboot.AppState;
import FacebootNet.Packets.Server.EPostStruct;
import View.Components.Comment;
import View.Components.CustomScrollBarUI;
import View.Components.Post;
import View.Components.PostWithAttachments;
import View.Components.SearchNotFound;
import View.Components.TextPrompt;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author orlandocamacho
 */
public class Home extends javax.swing.JFrame {
    
    private int mouseX;
    private int mouseY;
    private int PostOffset;
    private ArrayList<EPostStruct> Allposts;

    /**
     * Creates new form Login
     */
    public Home() {
        initComponents();
        
        new TextPrompt("Buscar en faceboot", search);
        new TextPrompt("Buscar usuarios", searchUsers);
        
        String separator = File.separator;
        
        if (separator.equals("/")) {
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 22, 22));
            this.DisposeButtonW.setVisible(false);
            this.MinimizeButtonW.setVisible(false);
            this.FullScreenButtonW.setVisible(false);
        } else {
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 0, 0));
            this.DisposeButton.setVisible(false);
            this.MinimizeButton.setVisible(false);
            this.FullScreenButton.setVisible(false);
        }
        
        postScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        usersScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
 
        setLocationRelativeTo(null);
        searchNotFound.setVisible(false);
    }
    
    public void RenderPosts(ArrayList<EPostStruct> posts){        
        search.requestFocus();
        this.Allposts = posts;
        
        int coordinateY = 160;
        
        scrollPosts.removeAll();
        scrollPosts.add(addPostRoundedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
                
        revalidate();
        for(EPostStruct post : posts){
            if (post.HasAttachment) {
                PostWithAttachments postComponentAtt = new PostWithAttachments();
                postComponentAtt.mapPost(post);
                scrollPosts.add(postComponentAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, coordinateY, -1, -1));
                coordinateY += postComponentAtt.getSize().height+20;
            } else {
                Post postComponent = new Post();
                postComponent.mapPost(post);
                scrollPosts.add(postComponent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, coordinateY, -1, -1));
                coordinateY += postComponent.getSize().height+20;
            }
        }
        
        if (coordinateY < 620){
            scrollPosts.setSize(738, 620);
            scrollPosts.setPreferredSize(new java.awt.Dimension(738, 620));
        } else {
            scrollPosts.setSize(738, coordinateY);
            scrollPosts.setPreferredSize(new java.awt.Dimension(738, coordinateY));
        }
        
//        Comment coment = new Comment();
//        scrollPosts.add(coment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, coordinateY-30, -1, -1));
       revalidate();
    }
    
    public void renderSearchPosts(String text){
        int coordinateY = 160;
        
        scrollPosts.removeAll();
        scrollPosts.add(addPostRoundedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        scrollPosts.add(searchNotFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        revalidate();
        
        for(EPostStruct post : Allposts){
            if(post.UserName.contains(text) || post.PostBody.contains(text)){
                if (post.HasAttachment) {
                    PostWithAttachments postComponentAtt = new PostWithAttachments();
                    postComponentAtt.mapPost(post);
                    scrollPosts.add(postComponentAtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, coordinateY, -1, -1));
                    coordinateY += postComponentAtt.getSize().height+20;
                } else {
                    Post postComponent = new Post();
                    postComponent.mapPost(post);
                    scrollPosts.add(postComponent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, coordinateY, -1, -1));
                    coordinateY += postComponent.getSize().height+20;
                }
            }
        }
        
        if (coordinateY == 160){
            searchNotFound.setVisible(true);
        } else {
            searchNotFound.setVisible(false);
        }
        
        if (coordinateY < 620){
            scrollPosts.setSize(738, 620);
            scrollPosts.setPreferredSize(new java.awt.Dimension(738, 620));
        } else {
            scrollPosts.setSize(738, coordinateY);
            scrollPosts.setPreferredSize(new java.awt.Dimension(738, coordinateY));
        }
        revalidate();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        users = new javax.swing.JPanel();
        usersScrollPane = new javax.swing.JScrollPane();
        scrollUsers = new javax.swing.JPanel();
        containerUserSearch = new View.Components.RoundPanelText();
        searchIcon1 = new javax.swing.JLabel();
        searchUsers = new javax.swing.JTextField();
        userChat1 = new View.Components.UserChat();
        userChat2 = new View.Components.UserChat();
        userChat3 = new View.Components.UserChat();
        userChat4 = new View.Components.UserChat();
        userChat5 = new View.Components.UserChat();
        userChat6 = new View.Components.UserChat();
        posts = new javax.swing.JPanel();
        postScrollPane = new javax.swing.JScrollPane();
        scrollPosts = new javax.swing.JPanel();
        addPostRoundedPane = new View.Components.RoundedPanel();
        containerUser1 = new View.Components.RoundPanelText();
        user1 = new javax.swing.JButton();
        containerPost = new View.Components.RoundPanelText();
        postButton = new javax.swing.JButton();
        containerPhoto = new View.Components.RoundedPanel();
        addPhoto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        searchNotFound = new View.Components.SearchNotFound();
        topBar = new javax.swing.JPanel();
        DisposeButton = new javax.swing.JLabel();
        MinimizeButton = new javax.swing.JLabel();
        FullScreenButton = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        DisposeButtonW = new javax.swing.JLabel();
        FullScreenButtonW = new javax.swing.JLabel();
        MinimizeButtonW = new javax.swing.JLabel();
        topMenu = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        containerSearch = new View.Components.RoundPanelText();
        searchIcon = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        containerHome = new View.Components.RoundedPanel();
        homeButton = new javax.swing.JButton();
        containerUser = new View.Components.RoundPanelText();
        user = new javax.swing.JButton();
        containerNotifications = new View.Components.RoundPanelText();
        notifications = new javax.swing.JButton();
        containerSettings = new View.Components.RoundPanelText();
        settings = new javax.swing.JButton();
        containerLogout = new View.Components.RoundPanelText();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(23, 24, 26));
        content.setFocusable(false);
        content.setPreferredSize(new java.awt.Dimension(1280, 670));
        content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users.setBackground(new java.awt.Color(23, 24, 26));
        users.setLayout(new javax.swing.BoxLayout(users, javax.swing.BoxLayout.LINE_AXIS));

        usersScrollPane.setBackground(new java.awt.Color(23, 24, 26));
        usersScrollPane.setBorder(null);
        usersScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        usersScrollPane.setPreferredSize(new java.awt.Dimension(100, 1000));

        scrollUsers.setBackground(new java.awt.Color(23, 24, 26));
        scrollUsers.setPreferredSize(new java.awt.Dimension(257, 1000));
        scrollUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        containerUserSearch.setBackground(new java.awt.Color(58, 59, 60));
        containerUserSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/search.png"))); // NOI18N
        containerUserSearch.add(searchIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        searchUsers.setBackground(new java.awt.Color(58, 59, 60));
        searchUsers.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        searchUsers.setForeground(new java.awt.Color(204, 204, 204));
        searchUsers.setBorder(null);
        searchUsers.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        containerUserSearch.add(searchUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 0, 150, 30));

        scrollUsers.add(containerUserSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, -1));
        scrollUsers.add(userChat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        scrollUsers.add(userChat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        scrollUsers.add(userChat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        scrollUsers.add(userChat4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));
        scrollUsers.add(userChat5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        scrollUsers.add(userChat6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        usersScrollPane.setViewportView(scrollUsers);

        users.add(usersScrollPane);

        content.add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 0, 257, 628));

        posts.setBackground(new java.awt.Color(23, 24, 26));
        posts.setLayout(new javax.swing.BoxLayout(posts, javax.swing.BoxLayout.Y_AXIS));

        postScrollPane.setBackground(new java.awt.Color(23, 24, 26));
        postScrollPane.setBorder(null);
        postScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        postScrollPane.setPreferredSize(new java.awt.Dimension(738, 1000));

        scrollPosts.setBackground(new java.awt.Color(23, 24, 26));
        scrollPosts.setPreferredSize(new java.awt.Dimension(738, 620));
        scrollPosts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addPostRoundedPane.setBackground(new java.awt.Color(35, 36, 37));
        addPostRoundedPane.setMinimumSize(new java.awt.Dimension(734, 120));
        addPostRoundedPane.setPreferredSize(new java.awt.Dimension(734, 120));
        addPostRoundedPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        containerUser1.setBackground(new java.awt.Color(58, 59, 60));
        containerUser1.setLayout(new java.awt.BorderLayout());

        user1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/user.png"))); // NOI18N
        user1.setContentAreaFilled(false);
        user1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        containerUser1.add(user1, java.awt.BorderLayout.CENTER);

        addPostRoundedPane.add(containerUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        containerPost.setBackground(new java.awt.Color(58, 59, 60));
        containerPost.setForeground(new java.awt.Color(204, 204, 204));
        containerPost.setLayout(new java.awt.BorderLayout());

        postButton.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        postButton.setForeground(new java.awt.Color(153, 153, 153));
        postButton.setText("¿Qué estás pensando?");
        postButton.setContentAreaFilled(false);
        postButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        postButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        postButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                postButtonMouseMoved(evt);
            }
        });
        postButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                postButtonMouseExited(evt);
            }
        });
        postButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postButtonActionPerformed(evt);
            }
        });
        containerPost.add(postButton, java.awt.BorderLayout.CENTER);

        addPostRoundedPane.add(containerPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 644, 40));

        containerPhoto.setBackground(new java.awt.Color(35, 36, 37));
        containerPhoto.setLayout(new java.awt.BorderLayout());

        addPhoto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addPhoto.setForeground(new java.awt.Color(153, 153, 153));
        addPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/insertPhoto.png"))); // NOI18N
        addPhoto.setText("Foto");
        addPhoto.setContentAreaFilled(false);
        addPhoto.setIconTextGap(10);
        addPhoto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                addPhotoMouseMoved(evt);
            }
        });
        addPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPhotoMouseExited(evt);
            }
        });
        addPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhotoActionPerformed(evt);
            }
        });
        containerPhoto.add(addPhoto, java.awt.BorderLayout.CENTER);

        addPostRoundedPane.add(containerPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 216, 40));
        addPostRoundedPane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 694, 10));

        scrollPosts.add(addPostRoundedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 120));
        scrollPosts.add(searchNotFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        postScrollPane.setViewportView(scrollPosts);

        posts.add(postScrollPane);

        content.add(posts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 774, 628));

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 1024, 628));

        topBar.setBackground(new java.awt.Color(31, 32, 36));
        topBar.setPreferredSize(new java.awt.Dimension(0, 35));
        topBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topBarMouseDragged(evt);
            }
        });
        topBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topBarMousePressed(evt);
            }
        });
        topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DisposeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DisposeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/DisposeButton.png"))); // NOI18N
        DisposeButton.setMaximumSize(new java.awt.Dimension(14, 14));
        DisposeButton.setMinimumSize(new java.awt.Dimension(14, 14));
        DisposeButton.setPreferredSize(new java.awt.Dimension(14, 14));
        DisposeButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DisposeButtonMouseMoved(evt);
            }
        });
        DisposeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DisposeButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DisposeButtonMousePressed(evt);
            }
        });
        topBar.add(DisposeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        MinimizeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/MinimizeButton.png"))); // NOI18N
        MinimizeButton.setMaximumSize(new java.awt.Dimension(14, 14));
        MinimizeButton.setMinimumSize(new java.awt.Dimension(14, 14));
        MinimizeButton.setPreferredSize(new java.awt.Dimension(14, 14));
        MinimizeButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MinimizeButtonMouseMoved(evt);
            }
        });
        MinimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MinimizeButtonMousePressed(evt);
            }
        });
        topBar.add(MinimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        FullScreenButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FullScreenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/FullScreenButton.png"))); // NOI18N
        FullScreenButton.setMaximumSize(new java.awt.Dimension(14, 14));
        FullScreenButton.setMinimumSize(new java.awt.Dimension(14, 14));
        FullScreenButton.setPreferredSize(new java.awt.Dimension(14, 14));
        FullScreenButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                FullScreenButtonMouseMoved(evt);
            }
        });
        FullScreenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FullScreenButtonMouseExited(evt);
            }
        });
        topBar.add(FullScreenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Faceboot.png"))); // NOI18N
        topBar.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 0, 145, 35));

        DisposeButtonW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DisposeButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/DisposeButtonW.png"))); // NOI18N
        DisposeButtonW.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DisposeButtonWMouseMoved(evt);
            }
        });
        DisposeButtonW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DisposeButtonWMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DisposeButtonWMousePressed(evt);
            }
        });
        topBar.add(DisposeButtonW, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 0, 55, 33));

        FullScreenButtonW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FullScreenButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/FullScreenButtonW.png"))); // NOI18N
        FullScreenButtonW.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                FullScreenButtonWMouseMoved(evt);
            }
        });
        FullScreenButtonW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FullScreenButtonWMouseExited(evt);
            }
        });
        topBar.add(FullScreenButtonW, new org.netbeans.lib.awtextra.AbsoluteConstraints(911, 0, 55, 33));

        MinimizeButtonW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinimizeButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/MinimizeButtonW.png"))); // NOI18N
        MinimizeButtonW.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MinimizeButtonWMouseMoved(evt);
            }
        });
        MinimizeButtonW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeButtonWMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MinimizeButtonWMousePressed(evt);
            }
        });
        topBar.add(MinimizeButtonW, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 0, 55, 33));

        getContentPane().add(topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, -1));

        topMenu.setBackground(new java.awt.Color(31, 32, 36));
        topMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/flogo.png"))); // NOI18N
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });
        topMenu.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 40, -1));

        containerSearch.setBackground(new java.awt.Color(58, 59, 60));

        searchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/search.png"))); // NOI18N

        search.setBackground(new java.awt.Color(58, 59, 60));
        search.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        search.setForeground(new java.awt.Color(204, 204, 204));
        search.setBorder(null);
        search.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        search.setFocusTraversalKeysEnabled(false);
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout containerSearchLayout = new javax.swing.GroupLayout(containerSearch);
        containerSearch.setLayout(containerSearchLayout);
        containerSearchLayout.setHorizontalGroup(
            containerSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerSearchLayout.setVerticalGroup(
            containerSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search)
                    .addGroup(containerSearchLayout.createSequentialGroup()
                        .addComponent(searchIcon)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        topMenu.add(containerSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 7, 190, 40));

        containerHome.setBackground(new java.awt.Color(31, 32, 36));
        containerHome.setLayout(new java.awt.BorderLayout());

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/home.png"))); // NOI18N
        homeButton.setContentAreaFilled(false);
        homeButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                homeButtonMouseMoved(evt);
            }
        });
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        containerHome.add(homeButton, java.awt.BorderLayout.CENTER);

        topMenu.add(containerHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 4, 104, 48));

        containerUser.setBackground(new java.awt.Color(58, 59, 60));
        containerUser.setLayout(new java.awt.BorderLayout());

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/user.png"))); // NOI18N
        user.setContentAreaFilled(false);
        user.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        user.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                userMouseMoved(evt);
            }
        });
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
        });
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        containerUser.add(user, java.awt.BorderLayout.CENTER);

        topMenu.add(containerUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 7, 40, 40));

        containerNotifications.setBackground(new java.awt.Color(58, 59, 60));
        containerNotifications.setLayout(new java.awt.BorderLayout());

        notifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/notifications.png"))); // NOI18N
        notifications.setContentAreaFilled(false);
        notifications.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        notifications.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                notificationsMouseMoved(evt);
            }
        });
        notifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notificationsMouseExited(evt);
            }
        });
        containerNotifications.add(notifications, java.awt.BorderLayout.CENTER);

        topMenu.add(containerNotifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 7, 40, 40));

        containerSettings.setBackground(new java.awt.Color(58, 59, 60));
        containerSettings.setLayout(new java.awt.BorderLayout());

        settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/settings.png"))); // NOI18N
        settings.setContentAreaFilled(false);
        settings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settings.setIconTextGap(0);
        settings.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                settingsMouseMoved(evt);
            }
        });
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsMouseExited(evt);
            }
        });
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });
        containerSettings.add(settings, java.awt.BorderLayout.CENTER);

        topMenu.add(containerSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(914, 7, 40, 40));

        containerLogout.setBackground(new java.awt.Color(58, 59, 60));
        containerLogout.setLayout(new java.awt.BorderLayout());

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/logout.png"))); // NOI18N
        logoutBtn.setToolTipText("Cerrar sesión");
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                logoutBtnMouseMoved(evt);
            }
        });
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnMouseExited(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        containerLogout.add(logoutBtn, java.awt.BorderLayout.CENTER);

        topMenu.add(containerLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(964, 7, 40, 40));

        getContentPane().add(topMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 1024, 57));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_topBarMousePressed

    private void topBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarMouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();

        setLocation(X - mouseX, Y - mouseY + 1);
    }//GEN-LAST:event_topBarMouseDragged

    private void DisposeButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisposeButtonMouseMoved
        DisposeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/DisposeButton2.png")));
    }//GEN-LAST:event_DisposeButtonMouseMoved

    private void DisposeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisposeButtonMouseExited
        DisposeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/DisposeButton.png")));
    }//GEN-LAST:event_DisposeButtonMouseExited

    private void MinimizeButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeButtonMouseMoved
        MinimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/MinimizeButton2.png")));
    }//GEN-LAST:event_MinimizeButtonMouseMoved

    private void MinimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeButtonMouseExited
        MinimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/MinimizeButton.png")));
    }//GEN-LAST:event_MinimizeButtonMouseExited

    private void FullScreenButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FullScreenButtonMouseMoved
        FullScreenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/FullScreenButton2.png")));
    }//GEN-LAST:event_FullScreenButtonMouseMoved

    private void FullScreenButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FullScreenButtonMouseExited
        FullScreenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/FullScreenButton.png")));
    }//GEN-LAST:event_FullScreenButtonMouseExited

    private void DisposeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisposeButtonMousePressed
        if (evt.getClickCount() >= 0) {
            System.exit(0);
        } 
    }//GEN-LAST:event_DisposeButtonMousePressed

    private void MinimizeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeButtonMousePressed
        if (evt.getClickCount() >= 0) {
            this.setExtendedState(1);  
        } 
    }//GEN-LAST:event_MinimizeButtonMousePressed

    private void DisposeButtonWMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisposeButtonWMouseMoved
        DisposeButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/DisposeButtonW2.png")));
    }//GEN-LAST:event_DisposeButtonWMouseMoved

    private void DisposeButtonWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisposeButtonWMouseExited
        DisposeButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/DisposeButtonW.png")));
    }//GEN-LAST:event_DisposeButtonWMouseExited

    private void FullScreenButtonWMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FullScreenButtonWMouseMoved
        FullScreenButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/FullScreenButtonW2.png")));
    }//GEN-LAST:event_FullScreenButtonWMouseMoved

    private void FullScreenButtonWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FullScreenButtonWMouseExited
        FullScreenButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/FullScreenButtonW.png")));
    }//GEN-LAST:event_FullScreenButtonWMouseExited

    private void MinimizeButtonWMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeButtonWMouseMoved
        MinimizeButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/MinimizeButtonW2.png")));
    }//GEN-LAST:event_MinimizeButtonWMouseMoved

    private void MinimizeButtonWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeButtonWMouseExited
         MinimizeButtonW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/MinimizeButtonW.png")));
    }//GEN-LAST:event_MinimizeButtonWMouseExited

    private void DisposeButtonWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisposeButtonWMousePressed
        if (evt.getClickCount() >= 0) {
            System.exit(0);
        } 
    }//GEN-LAST:event_DisposeButtonWMousePressed

    private void MinimizeButtonWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeButtonWMousePressed
        if (evt.getClickCount() >= 0) {
            this.setExtendedState(1);  
        } 
    }//GEN-LAST:event_MinimizeButtonWMousePressed

    private void homeButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseMoved
        containerHome.setBackground(new Color(58,59,60));
    }//GEN-LAST:event_homeButtonMouseMoved

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        containerHome.setBackground(new Color(31,32,36));
    }//GEN-LAST:event_homeButtonMouseExited

    private void userMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseMoved
        containerUser.setBackground(new Color(84,86,86));
    }//GEN-LAST:event_userMouseMoved

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        containerUser.setBackground(new Color(58,59,60));
    }//GEN-LAST:event_userMouseExited

    private void notificationsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsMouseMoved
        containerNotifications.setBackground(new Color(84,86,86));
    }//GEN-LAST:event_notificationsMouseMoved

    private void notificationsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationsMouseExited
        containerNotifications.setBackground(new Color(58,59,60));
    }//GEN-LAST:event_notificationsMouseExited

    private void settingsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseMoved
        containerSettings.setBackground(new Color(84,86,86));
    }//GEN-LAST:event_settingsMouseMoved

    private void settingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseExited
        containerSettings.setBackground(new Color(58,59,60));
    }//GEN-LAST:event_settingsMouseExited

    private void addPhotoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPhotoMouseMoved
        containerPhoto.setBackground(new Color(58,59,60));
    }//GEN-LAST:event_addPhotoMouseMoved

    private void addPhotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPhotoMouseExited
        containerPhoto.setBackground(new Color(35,36,37));
    }//GEN-LAST:event_addPhotoMouseExited

    private void postButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postButtonMouseExited
        containerPost.setBackground(new Color(58,59,60));
    }//GEN-LAST:event_postButtonMouseExited

    private void postButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postButtonMouseMoved
        containerPost.setBackground(new Color(78,78,79));
    }//GEN-LAST:event_postButtonMouseMoved

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        PostOffset = 0;
        App.GetSingleton().Client.DoFetchPosts(PostOffset);
        postButton.setText("¿Qué estás pensando, " + App.GetSingleton().UserName + "?");
    }//GEN-LAST:event_formComponentShown

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        App.GetSingleton().SetState(AppState.Profile);
    }//GEN-LAST:event_userActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        App.GetSingleton().SetState(AppState.Settings);
    }//GEN-LAST:event_settingsActionPerformed

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        App.GetSingleton().SetState(AppState.Home);
    }//GEN-LAST:event_logoMouseClicked

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        App.GetSingleton().SetState(AppState.Home);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postButtonActionPerformed
        App.GetSingleton().SetState(AppState.CreatePostHome);
    }//GEN-LAST:event_postButtonActionPerformed

    private void addPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhotoActionPerformed
        App.GetSingleton().SetState(AppState.CreatePostHome);
    }//GEN-LAST:event_addPhotoActionPerformed

    private void logoutBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseMoved
        containerLogout.setBackground(new Color(58,59,60));
    }//GEN-LAST:event_logoutBtnMouseMoved

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseExited
        containerLogout.setBackground(new Color(35,36,37));
    }//GEN-LAST:event_logoutBtnMouseExited

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO logout
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            renderSearchPosts(search.getText());
        }
    }//GEN-LAST:event_searchKeyPressed

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        if(search.getText().length() == 0){
            App.GetSingleton().Client.DoFetchPosts(0);
        }
    }//GEN-LAST:event_searchKeyTyped
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DisposeButton;
    private javax.swing.JLabel DisposeButtonW;
    private javax.swing.JLabel FullScreenButton;
    private javax.swing.JLabel FullScreenButtonW;
    private javax.swing.JLabel MinimizeButton;
    private javax.swing.JLabel MinimizeButtonW;
    private javax.swing.JLabel Title;
    private javax.swing.JButton addPhoto;
    private View.Components.RoundedPanel addPostRoundedPane;
    private View.Components.RoundedPanel containerHome;
    private View.Components.RoundPanelText containerLogout;
    private View.Components.RoundPanelText containerNotifications;
    private View.Components.RoundedPanel containerPhoto;
    private View.Components.RoundPanelText containerPost;
    private View.Components.RoundPanelText containerSearch;
    private View.Components.RoundPanelText containerSettings;
    private View.Components.RoundPanelText containerUser;
    private View.Components.RoundPanelText containerUser1;
    private View.Components.RoundPanelText containerUserSearch;
    private javax.swing.JPanel content;
    private javax.swing.JButton homeButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton notifications;
    private javax.swing.JButton postButton;
    private javax.swing.JScrollPane postScrollPane;
    private javax.swing.JPanel posts;
    private javax.swing.JPanel scrollPosts;
    private javax.swing.JPanel scrollUsers;
    private javax.swing.JTextField search;
    private javax.swing.JLabel searchIcon;
    private javax.swing.JLabel searchIcon1;
    private View.Components.SearchNotFound searchNotFound;
    private javax.swing.JTextField searchUsers;
    private javax.swing.JButton settings;
    private javax.swing.JPanel topBar;
    private javax.swing.JPanel topMenu;
    private javax.swing.JButton user;
    private javax.swing.JButton user1;
    private View.Components.UserChat userChat1;
    private View.Components.UserChat userChat2;
    private View.Components.UserChat userChat3;
    private View.Components.UserChat userChat4;
    private View.Components.UserChat userChat5;
    private View.Components.UserChat userChat6;
    private javax.swing.JPanel users;
    private javax.swing.JScrollPane usersScrollPane;
    // End of variables declaration//GEN-END:variables
}
