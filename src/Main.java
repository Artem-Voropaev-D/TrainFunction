import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    static Dimension dimension = toolkit.getScreenSize();
    static JFrame jFrame = getFrame();
    static Font font = new Font("Courier New", Font.BOLD, dimension.height*dimension.width/87000);
    static Font fontg = new Font("Tahoma", Font.BOLD, dimension.width*dimension.height/150000);
    static Font font_train = new Font("Tahoma", Font.BOLD, dimension.height*dimension.width/130000);
    static Font font_func = new Font("Courier New", Font.BOLD, dimension.height*dimension.width/58000);
    static double Parabola_koefA = 1;
    static double Parabola_koefB = 0;
    static double Parabola_koefC = 0;
    static double Parabola_koefPriX = 0;
    static double Parabola_koefD = 0;
    static double Line_koefK = 1;
    static double Line_koefB = 0;
    static double Sqrt_koefK = 1;
    static double Sqrt_koefB = 0;
    static double Sqrt_koefD = 0;
    static double Sqrt_koefPriX = 0;
    static double Log_Osnovanie = 1;
    static double Log_KoefK = 0;
    static double Log_KoefB = 0;
    static double Log_KoefPriX = 0;
    static double Log_KoefD = 0;
    static double Giper_koefK = 1;
    static double Giper_koefB = 0;
    static double Giper_koefD = 0;
    static double Giper_koefPriX = 0;
    static double Sin_koefK = 1;
    static double Sin_koefB = 0;
    static double Sin_koefD = 0;
    static double Sin_koefPriX = 0;
    static double Cos_koefK = 1;
    static double Cos_koefB = 0;
    static double Cos_koefD = 0;
    static double Cos_koefPriX = 0;
    static double e_koefK = 1;
    static double e_koefB = 0;
    static double e_koefD = 0;
    static double e_koefPriX = 0;
    static double aX_koefK = 1;
    static double aX_osnovanie = 1;
    static double aX_koefB = 0;
    static double aX_koefD = 0;
    static double aX_koefPriX = 0;


    public static void StartMenu(){
        jFrame.setTitle("Главное меню");
        jFrame.setContentPane(new Container());//пустой контейнер как фон

        JButton Training = new JButton("Обучение"); // создание кнопки, в качестве аргумента JButton указываем название
        Training.setFont(font); // установка шрифта для отображения текста кнопки
        Training.setBounds(dimension.width/2 - dimension.width*28/512, dimension.height/8 - dimension.height*5/216,
                dimension.width*28/256, dimension.height*463/10000); // установка расположения и размеров кнопки
        Training.addActionListener(new ActionListener() { // addActionListener - фукнция, описывающая действие кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();// удаление всех компонентов с jframe
                jFrame.repaint();// восстановление jframe

                jFrame.setTitle("Обучение");

                ImageIcon background = new ImageIcon("img/g.jpg"); // Укажите путь к изображению для фона

                //пересоздаем ImageIcon для того, чтобы настраивать размеры изображения
                JLabel backgroundLabel = new JLabel(new ImageIcon(background.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH)));
                jFrame.setContentPane(backgroundLabel); // setContentPane - установка фона на jframe

                JButton Return = new JButton("Главное меню");
                Return.setFont(font_train);
                Return.setBackground(new Color(173,216,230));
                Return.setForeground(Color.WHITE); // установка цвета текста у кнопки
                Return.setFocusPainted(false); // фокус при наведении/нажатии на кнопку
                Return.setBounds( 20, 25, 120, 40);
                Return.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                Return.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.getContentPane().removeAll();
                        jFrame.repaint();
                        StartMenu(); // вызов стартового меню
                    }
                });
                jFrame.add(Return);

                // JLabel - универсальный контейнер, который можно расположить на jframe
                JLabel label = new JLabel("Пожалуйста, выберите функцию, с которой желаете ознакомиться");
                label.setBounds(375, 25, 1000, 40);//координаты

                Font customFont = null; // создаем экземпляр Font, чтобы позже положить в него свой шрифт
                File fontFile = new File("img/Softie_Cyr.ttf");// путь к шрифту
                try {
                    customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);// создание нового шрифта
                    customFont = customFont.deriveFont(28f); // задание размера шрифта
                }
                catch (FontFormatException | IOException a) {
                    a.printStackTrace();
                }

                label.setFont(customFont);
                label.setForeground(new Color(141, 213, 235));// градиент цвета
                jFrame.add(label);

//                ImageIcon Human_left = new ImageIcon("img/ou.gif");
//                JLabel label_Human_left = new JLabel(Human_left);
//                label_Human_left.setBounds(-180, 350, 800, 400);
//                jFrame.add(label_Human_left);
//
//                ImageIcon Human_right = new ImageIcon("img/ou2.gif");
//                JLabel label_Human_right = new JLabel(Human_right);
//                label_Human_right.setBounds(900, 350, 800, 400);
//                jFrame.add(label_Human_right);

                JButton Train_Parabola = new JButton("Парабола");
                Train_Parabola.setFont(font_train);
                Train_Parabola.setBackground(new Color(173,216,230));
                Train_Parabola.setForeground(Color.WHITE);
                Train_Parabola.setFocusPainted(false);
                Train_Parabola.setBounds( 680, 80, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                Train_Parabola.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                jFrame.add(Train_Parabola);

                Train_Parabola.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.getContentPane().removeAll();
                        jFrame.repaint();
                        jFrame.setTitle("Парабола");

                        // html табуляция, используется для корректного переноса строк, так как стандартные специальне символы не используются у JLabel
                        JLabel ParabolaOne = new JLabel(
                                "<html>Парабола (греч. Παραβολή ) — геометрическое<br>" +
                                        "место точек, равноудалённых от данной<br>" +
                                        " прямой (называемой директрисой параболы)<br>" +
                                        "и данной точки (называемой фокусом параболы).<br>" +
                                        "<br>" +
                                        "Функция вида у = ax^2+bx+c, где а, b, с<br>" +
                                        "- заданные числа, a ≠ o, х - действительная<br>" +
                                        "переменная, называется квадратичной функцией.<br>" +
                                        "Графиком этой функции является парабола.<br>" +
                                        "<br>Приведем пример функции y = x^2</html>");
                        ParabolaOne.setBounds(20, 42, 760, 450);
                        Font font_ParabolaOne = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/40000);
                        ParabolaOne.setFont(font_ParabolaOne);
                        jFrame.add(ParabolaOne);

                        //размеры у d и b должны совпадать!!!
                        ImageIcon b = new ImageIcon("img/parabola11.png");

                        JLabel d = new JLabel(new ImageIcon(b.getImage().getScaledInstance(620, 650, Image.SCALE_SMOOTH)));
                        d.setBounds(dimension.width/2 + 40, dimension.height/2 - 370, 620, 650);
                        jFrame.add(d);

                        JButton NextOne = new JButton("Далее");
                        NextOne.setFont(font_train);
                        NextOne.setBackground(Color.gray);
                        NextOne.setForeground(Color.WHITE);
                        NextOne.setFocusPainted(false);
                        NextOne.setBounds( 20, 670, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                        NextOne.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                        jFrame.add(NextOne);
                        NextOne.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                jFrame.getContentPane().removeAll();
                                jFrame.repaint();

                                JLabel ParabolaTwo = new JLabel(
                                        "<html>Посмотрим внимательно на график y = x^2 и перечислим его основные свойства.<br>" +
                                                "1) Функция y = x^2 определена для всех x, от минус бесконечности до плюс бесконечности.<br>" +
                                                "Другими словами, в формулу y = x^2 можно подставить любой x.<br>" +
                                                "2) Область значений этой функции – неотрицательные числа. Весь график расположен не<br>" +
                                                "ниже оси Х, потому что квадрат любого числа – величина неотрицательная.<br>" +
                                                "3) Если x=0, то y=0. Можно сказать, что при x=0 парабола касается оси Х.<br>" +
                                                "4) Точка (0; 0) на графике называется вершиной параболы. Конечно, это немного странно: <br>" +
                                                "ведь точка (0; 0) на графике – это, наоборот, ямка, самая низкая точка. Но таково название.<br>" +
                                                "5) Легко заметить, что график квадратичной функции симметричен относительно оси Y.<br>" +
                                                "Например, при x=3 и x=-3 функция принимает одинаковые значения, равные 9.<br>" +
                                                "При x=2 и x=-2 также одинаковые значения, равные 4.<br>" +
                                                "В общем виде формула квадратичной функции выглядит так:<br>" +
                                                "y = ax^2 + bx + c<br>" +
                                                "</html>");
                                ParabolaTwo.setBounds(20, 5, 850, 350);
                                Font font_ParabolaTwo = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/80000);
                                ParabolaTwo.setFont(font_ParabolaTwo);
                                jFrame.add(ParabolaTwo);

                                //размеры у d и b должны совпадать!!! делаем на пустом листе в поверпоинте там формулы и тд и добавляем с кайфом, а можно в начале прям слайды добавить
                                ImageIcon Parabola_icon2_left = new ImageIcon("img/parabola11.png");

                                JLabel Parabola_lable_left = new JLabel(new ImageIcon(Parabola_icon2_left.getImage().getScaledInstance(620, 420, Image.SCALE_SMOOTH)));
                                Parabola_lable_left.setBounds(22, 330 , 620, 420);
                                jFrame.add(Parabola_lable_left);

                                //right

                                JLabel ParabolaTwo_2 = new JLabel(
                                        "<html>Построим график функции y = x^2 + 3.<br>" +
                                                "Графики функции y = x^2 + 3  сдвинут на 3<br>" +
                                                "вверх по отношению к графику функции y = x^2.<br>" +
                                                "Потому что к каждому значению функции y = x^2 <br>" +
                                                "мы прибавили 3, и график сдвинулся на 3 вверх.<br>" +
                                                "</html>");
                                ParabolaTwo_2.setBounds(720, 5, 600, 190);
                                ParabolaTwo_2.setFont(font_ParabolaTwo);
                                jFrame.add(ParabolaTwo_2);

                                ImageIcon Parabola_icon2_right = new ImageIcon("img/parabola2_r.png");

                                JLabel Parabola_lable_right = new JLabel(new ImageIcon(Parabola_icon2_right.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                Parabola_lable_right.setBounds(720, 330 , 380, 420);
                                jFrame.add(Parabola_lable_right);

                                //right2

                                JLabel ParabolaTwo_3 = new JLabel(
                                        "<html>Следующий -  график функции y = x^2 - 2 <br>" +
                                                "сдвинут на 2 вниз по отношению к графику функции<br>" +
                                                "y = x^2.  Потому что из каждого значения функции <br>" +
                                                "мы вычитаем 2, и график сдвигается на 2 вниз.<br>" +
                                                "<br>" +
                                                "</html>");
                                ParabolaTwo_3.setBounds(1120, 5, 600, 190);
                                ParabolaTwo_3.setFont(font_ParabolaTwo);
                                jFrame.add(ParabolaTwo_3);

                                ImageIcon Parabola_icon2_right2 = new ImageIcon("img/parabola2_r2.png");

                                JLabel Parabola_lable_right2 = new JLabel(new ImageIcon(Parabola_icon2_right2.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                Parabola_lable_right2.setBounds(1120, 330 , 380, 420);
                                jFrame.add(Parabola_lable_right2);


                                JLabel ParabolaTwo_3_botton = new JLabel(
                                        "<html>Мы поняли, как строить график функции y = x^2 + c. Если c>0, то он будет сдвинут на с вверх по отношению<br>" +
                                                "к графику функции y = x^2. Если 0>c, то сдвинут на с вниз. Как будто мы вырезали шаблон графика y = x^2<br>" +
                                                "из бумаги и двигаем его вверх-вниз. Можно сказать, что график функции y = x^2 + c получается из графика <br>" +
                                                "y = x^2 параллельным переносом вверх (если c>0) или вниз (если 0>c). Таким образом, коэффицент с<br> " +
                                                "отвечает за пересечение параболы с осью oY, убедимся в этом в дальнейшем.<br>" +
                                                "</html>");
                                ParabolaTwo_3_botton.setBounds(720, 5, 900, 410);
                                ParabolaTwo_3_botton.setFont(font_ParabolaTwo);
                                jFrame.add(ParabolaTwo_3_botton);

                                JButton NextTwo = new JButton("Далее");
                                NextTwo.setFont(font_train);
                                NextTwo.setBackground(Color.gray);
                                NextTwo.setForeground(Color.WHITE);
                                NextTwo.setFocusPainted(false);
                                NextTwo.setBounds( 1350, 280, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                NextTwo.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                jFrame.add(NextTwo);
                                NextTwo.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jFrame.getContentPane().removeAll();
                                        jFrame.repaint();

                                        //1 лейбл
                                        JLabel ParabolaThree = new JLabel(
                                                "<html>Разберем некоторые примеры, связанные с коэффицентом c<br>" +
                                                        "</html>");
                                        ParabolaThree.setBounds(315, 22, 960, 80);
                                        Font font_ParabolaOne = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/40000);
                                        ParabolaThree.setFont(font_ParabolaOne);
                                        jFrame.add(ParabolaThree);

                                        //2 лейбл
                                        JLabel ParabolaThree_bot = new JLabel(
                                                "<html>Определите значение коэффицента c:<br>" +
                                                        "</html>");
                                        ParabolaThree_bot.setBounds(115, 202, 500, 40);
                                        Font font_ParabolaOn = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);
                                        ParabolaThree_bot.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot);

                                        //первая картинка слева
                                        ImageIcon Parabola_icon3_left = new ImageIcon("img/parabola3_l.png");

                                        JLabel Parabola_lable3_left = new JLabel(new ImageIcon(Parabola_icon3_left.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Parabola_lable3_left.setBounds(25, 280 , 350, 420);
                                        jFrame.add(Parabola_lable3_left);

                                        //самый низ
                                        JLabel ParabolaThree_bot2 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        ParabolaThree_bot2.setBounds(25, 700, 100, 40);
                                        ParabolaThree_bot2.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot2);

                                        // JTextField - контейнер, принимающий ввод символов с клавиатуры
                                        JTextField Answer1 = new JTextField();
                                        Answer1.setBounds(100, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer1);

                                        //вторая картинка слева
                                        ImageIcon Parabola_icon3_left2 = new ImageIcon("img/parabola3_l2.png");

                                        JLabel Parabola_lable3_left2 = new JLabel(new ImageIcon(Parabola_icon3_left2.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Parabola_lable3_left2.setBounds(390, 280 , 350, 420);
                                        jFrame.add(Parabola_lable3_left2);

                                        //самый низ2
                                        JLabel ParabolaThree_bot3 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        ParabolaThree_bot3.setBounds(390, 700, 100, 40);
                                        ParabolaThree_bot3.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot3);

                                        JTextField Answer2 = new JTextField();
                                        Answer2.setBounds(465, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer2);

                                        //правое задание

                                        //2 лейбл справа
                                        JLabel ParabolaThree_botR = new JLabel(
                                                "<html>Определите знак коэффицента c: (ответы +/-)<br>" +
                                                        "</html>");
                                        ParabolaThree_botR.setBounds(875, 202, 500, 40);
                                        //Font font_ParabolaOn = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);
                                        ParabolaThree_botR.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_botR);

                                        //третья картинка слева
                                        ImageIcon Parabola_icon3_left3 = new ImageIcon("img/parabola3_l3.png");

                                        JLabel Parabola_lable3_left3 = new JLabel(new ImageIcon(Parabola_icon3_left3.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Parabola_lable3_left3.setBounds(785, 280 , 350, 420);
                                        jFrame.add(Parabola_lable3_left3);

                                        //самый низ3
                                        JLabel ParabolaThree_bot4 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        ParabolaThree_bot4.setBounds(785, 700, 100, 40);
                                        ParabolaThree_bot4.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot4);

                                        JTextField Answer3 = new JTextField();
                                        Answer3.setBounds(860, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer3);

                                        //4 картинка слева
                                        ImageIcon Parabola_icon3_left4 = new ImageIcon("img/parabola3_l4.png");

                                        JLabel Parabola_lable3_left4 = new JLabel(new ImageIcon(Parabola_icon3_left4.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Parabola_lable3_left4.setBounds(1150, 280 , 350, 420);
                                        jFrame.add(Parabola_lable3_left4);

                                        //самый низ4
                                        JLabel ParabolaThree_bot5 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        ParabolaThree_bot5.setBounds(1150, 700, 100, 40);
                                        ParabolaThree_bot5.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot5);

                                        JTextField Answer4 = new JTextField();
                                        Answer4.setBounds(1225, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer4);

                                        // кнопка - служащая проверкой введнных пользователем ответом, посредством сравнения в операторе if
                                        JButton Proverka = new JButton("Проверить");
                                        Proverka.setFont(font_train);
                                        Proverka.setBackground(Color.gray);
                                        Proverka.setForeground(Color.WHITE);
                                        Proverka.setFocusPainted(false);
                                        Proverka.setBounds( 25, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                        Proverka.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                        jFrame.add(Proverka);

                                        //верно/неверно лейблы

                                        JLabel ParabolaThree_bot22 = new JLabel(
                                                "");
                                        ParabolaThree_bot22.setBounds(150, 714,200, 20);
                                        ParabolaThree_bot22.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot22);

                                        JLabel ParabolaThree_bot33 = new JLabel(
                                                "");
                                        ParabolaThree_bot33.setBounds(515, 714,200, 20);
                                        ParabolaThree_bot33.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot33);

                                        JLabel ParabolaThree_bot44 = new JLabel(
                                                "");
                                        ParabolaThree_bot44.setBounds(910, 714,200, 20);
                                        ParabolaThree_bot44.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot44);

                                        JLabel ParabolaThree_bot55 = new JLabel(
                                                "");
                                        ParabolaThree_bot55.setBounds(1275, 714,200, 20);
                                        ParabolaThree_bot55.setFont(font_ParabolaOn);
                                        jFrame.add(ParabolaThree_bot55);

                                        //устанавливаем искомые значения ответов, позже удалить
                                        Answer1.setText("3");
                                        Answer2.setText("-3");
                                        Answer3.setText("-");
                                        Answer4.setText("+");

                                        JButton NextThree = new JButton("Далее");
                                        NextThree.setFont(font_train);
                                        NextThree.setBackground(Color.gray);
                                        NextThree.setForeground(Color.WHITE);
                                        NextThree.setFocusPainted(false);
                                        NextThree.setBounds( 1350, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                        NextThree.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                        jFrame.add(NextThree);

                                        Proverka.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                // переменная, отвечающая за проверку на правильность каждого введенного ответа
                                                Boolean Koef_C = true;

                                                // !Answer1.getText().isEmpty() - проверка на не пустую строку
                                                // Integer.parseInt(Answer1.getText()) == 3 - сравнение введенного ответа с искомым
                                                if(!Answer1.getText().isEmpty() && Integer.parseInt(Answer1.getText()) == 3){//Считываем введенные кэфы пользователем
                                                    //заменяем текст пустого jlabel в зависимости от правильности ответа
                                                    ParabolaThree_bot22.setText("Верно!");
                                                }
                                                else {
                                                    ParabolaThree_bot22.setText("Неверно!");
                                                    Koef_C = false;
                                                }
                                                if(!Answer2.getText().isEmpty() && Integer.parseInt(Answer2.getText()) == -3){//Считываем введенные кэфы пользователем
                                                    ParabolaThree_bot33.setText("Верно!");
                                                }
                                                else {
                                                    ParabolaThree_bot33.setText("Неверно!");
                                                    Koef_C = false;
                                                }
                                                if(!Answer3.getText().isEmpty() && Answer3.getText().equals("-")){//Считываем введенные кэфы пользователем
                                                    ParabolaThree_bot44.setText("Верно!");
                                                }
                                                else {
                                                    ParabolaThree_bot44.setText("Неверно!");
                                                    Koef_C = false;
                                                }
                                                if(!Answer4.getText().isEmpty() && Answer4.getText().equals("+")){//Считываем введенные кэфы пользователем
                                                    ParabolaThree_bot55.setText("Верно!");
                                                }
                                                else {
                                                    ParabolaThree_bot55.setText("Неверно!");
                                                    Koef_C = false;
                                                }

                                                if(Koef_C){ // если все ответы верны, то пользователь имеет право перейти к следующему слайду

                                                    NextThree.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            jFrame.getContentPane().removeAll();
                                                            jFrame.repaint();

                                                            JLabel ParabolaFour = new JLabel(
                                                                    "<html>Если функция задана формулой y=(x-a)^2 и a>0, её график сдвинут относительно графика y= x^2 на a<br>" +
                                                                            "вправо. А график функции y=(x+a)^2 при a>0 сдвинут относительно графика функции y= x^2 на a влево.<br>" +
                                                                            "</html>");
                                                            ParabolaFour.setBounds(20, 15, 850, 40);
                                                            ParabolaFour.setFont(font_ParabolaTwo);
                                                            jFrame.add(ParabolaFour);

                                                            ImageIcon Parabola_icon4_left = new ImageIcon("img/parabola4_l.png");

                                                            JLabel Parabola_lable4_left = new JLabel(new ImageIcon(Parabola_icon4_left.getImage().getScaledInstance(795, 350, Image.SCALE_SMOOTH)));
                                                            Parabola_lable4_left.setBounds(12, 70 , 790, 350);
                                                            jFrame.add(Parabola_lable4_left);

                                                            JLabel ParabolaFour2 = new JLabel(
                                                                    "<html>Знак коэффициента a отвечает за <br>" +
                                                                            "направление ветвей. При a>0 ветви <br>" +
                                                                            "направлены вверх, при 0>a — вниз. <br>" +
                                                                            "На рисунке приведены две параболы <br>" +
                                                                            "y = ax^2 с равными по модулю, но  <br>" +
                                                                            "противоположными по знаку значениями <br>" +
                                                                            "a. Абсолютная величина коэффициента <br>" +
                                                                            "a отвечает за «раскрыв» параболы. Чем <br>" +
                                                                            "больше |a|, тем у́же парабола (больше <br>" +
                                                                            "прижата к оси Y). Наоборот, чем меньше <br>" +
                                                                            "|a|, тем шире парабола (больше прижата <br>" +
                                                                            "к оси X) . На рисунке показаны две параболы <br>" +
                                                                            "y = x^2 и y = 3x^2.<br>" +
                                                                            "</html>");
                                                            ParabolaFour2.setBounds(20, 430, 425, 280);
                                                            ParabolaFour2.setFont(font_ParabolaTwo);
                                                            jFrame.add(ParabolaFour2);

                                                            ImageIcon Parabola_icon4_left2 = new ImageIcon("img/parabola4_l2.png");

                                                            JLabel Parabola_lable4_left2 = new JLabel(new ImageIcon(Parabola_icon4_left2.getImage().getScaledInstance(452, 350, Image.SCALE_SMOOTH)));
                                                            Parabola_lable4_left2.setBounds(350, 435 , 452, 350);
                                                            jFrame.add(Parabola_lable4_left2);

                                                            ImageIcon Parabola_icon4_left3 = new ImageIcon("img/parabola4_l3.png");

                                                            JLabel Parabola_lable4_left3 = new JLabel(new ImageIcon(Parabola_icon4_left3.getImage().getScaledInstance(452, 350, Image.SCALE_SMOOTH)));
                                                            Parabola_lable4_left3.setBounds(817, 435 , 452, 350);
                                                            jFrame.add(Parabola_lable4_left3);

                                                            JLabel ParabolaFour3 = new JLabel(
                                                                    "<html>Абсцисса вершины параболы y = ax^2 + bx + c находится по формуле: x_0=-b/2a<br>" +
                                                                            "Чтобы найти ординату вершины y_0, удобнее всего подставить x_0 в уравнение параболы.<br>" +
                                                                            "Но вообще, полезно помнить, что y_0=-D/4a, где D = b^2 - 4ac — дискриминант.<br>" +
                                                                            "<br>" +
                                                                            "Точки пересечения параболы y = ax^2 + bx + c с осью X – это корни квадратного <br>" +
                                                                            "уравнения ax^2 + bx + c=0. Если дискриминант равен нулю, то парабола касается<br>" +
                                                                            " оси X. Если дискриминант меньше нуля, то корней нет, и парабола не пересекает ось X.<br>" +
                                                                            "<br>" +
                                                                            "Точка пересечения с осью Y находится легко: мы подставляем x = 0 в уравнение параболы. <br>" +
                                                                            "Получается точка (0,c). И пользуемся тем, что квадратичная парабола симметрична <br>" +
                                                                            "относительно прямой, проходящей через ее вершину.<br>" +
                                                                            "</html>");
                                                            ParabolaFour3.setBounds(820, 15, 850, 220);
                                                            ParabolaFour3.setFont(font_ParabolaTwo);
                                                            jFrame.add(ParabolaFour3);

                                                            JButton NextFour = new JButton("Далее");
                                                            NextFour.setFont(font_train);
                                                            NextFour.setBackground(Color.gray);
                                                            NextFour.setForeground(Color.WHITE);
                                                            NextFour.setFocusPainted(false);
                                                            NextFour.setBounds( 1350, 380, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                                            NextFour.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                                            jFrame.add(NextFour);
                                                            NextFour.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    jFrame.getContentPane().removeAll();
                                                                    jFrame.repaint();

                                                                    JLabel ParabolaFive = new JLabel(
                                                                            "<html>Разберем некоторые примеры, связанные с коэффицентами a и b<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive.setBounds(315, 22, 980, 80);
                                                                    ParabolaFive.setFont(font_ParabolaOne);
                                                                    jFrame.add(ParabolaFive);

                                                                    //2 лейбл
                                                                    JLabel ParabolaFive_bot = new JLabel(
                                                                            "<html>Определите знак коэффицента a: (ответы +/-)<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_bot.setBounds(115, 202, 500, 40);
                                                                    //Font font_ParabolaOn = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);
                                                                    ParabolaFive_bot.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot);

                                                                    //первая картинка слева
                                                                    ImageIcon Parabola_icon5_left = new ImageIcon("img/parabola5_l.png");

                                                                    JLabel Parabola_lable5_left = new JLabel(new ImageIcon(Parabola_icon5_left.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                                                    Parabola_lable5_left.setBounds(25, 280 , 350, 420);
                                                                    jFrame.add(Parabola_lable5_left);

                                                                    //самый низ
                                                                    JLabel ParabolaFive_bot2 = new JLabel(
                                                                            "<html>Ответ:<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_bot2.setBounds(25, 700, 100, 40);
                                                                    ParabolaFive_bot2.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot2);

                                                                    JTextField Answer1Final = new JTextField();
                                                                    Answer1Final.setBounds(100, 714,20, 20); // кроссплатформенность
                                                                    jFrame.add(Answer1Final);

                                                                    //вторая картинка слева
                                                                    ImageIcon Parabola_icon5_left2 = new ImageIcon("img/parabola5_l2.png");

                                                                    JLabel Parabola_lable5_left2 = new JLabel(new ImageIcon(Parabola_icon5_left2.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                                                    Parabola_lable5_left2.setBounds(390, 280 , 350, 420);
                                                                    jFrame.add(Parabola_lable5_left2);

                                                                    //самый низ2
                                                                    JLabel ParabolaFive_bot3 = new JLabel(
                                                                            "<html>Ответ:<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_bot3.setBounds(390, 700, 100, 40);
                                                                    ParabolaFive_bot3.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot3);

                                                                    JTextField Answer2Final = new JTextField();
                                                                    Answer2Final.setBounds(465, 714,20, 20); // кроссплатформенность
                                                                    jFrame.add(Answer2Final);

                                                                    //правое задание

                                                                    //2 лейбл справа
                                                                    JLabel ParabolaFive_botR = new JLabel(
                                                                            "<html>Определите значение вершины параболы:<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_botR.setBounds(875, 202, 500, 40);
                                                                    //Font font_ParabolaOn = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);
                                                                    ParabolaFive_botR.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_botR);


                                                                    JLabel ParabolaFive_botR2 = new JLabel(
                                                                            "<html>y = x^2+4x-3.6<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_botR2.setBounds(785, 240, 500, 40);
                                                                    //Font font_ParabolaOn = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);
                                                                    ParabolaFive_botR2.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_botR2);

                                                                    JLabel ParabolaFive_botR3 = new JLabel(
                                                                            "<html>y = -x^2+3x-3.6<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_botR3.setBounds(1150, 240, 500, 40);
                                                                    //Font font_ParabolaOn = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);
                                                                    ParabolaFive_botR3.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_botR3);

                                                                    //третья картинка слева
                                                                    ImageIcon Parabola_icon5_left3 = new ImageIcon("img/parabola5_l3.png");

                                                                    JLabel Parabola_lable5_left3 = new JLabel(new ImageIcon(Parabola_icon5_left3.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                                                    Parabola_lable5_left3.setBounds(785, 280 , 350, 420);
                                                                    jFrame.add(Parabola_lable5_left3);

                                                                    //самый низ3
                                                                    JLabel ParabolaFive_bot4 = new JLabel(
                                                                            "<html>Ответ:<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_bot4.setBounds(785, 700, 100, 40);
                                                                    ParabolaFive_bot4.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot4);

                                                                    JTextField Answer3Final = new JTextField();
                                                                    Answer3Final.setBounds(860, 714,20, 20); // кроссплатформенность
                                                                    jFrame.add(Answer3Final);

                                                                    //4 картинка слева
                                                                    ImageIcon Parabola_icon5_left4 = new ImageIcon("img/parabola5_l4.png");

                                                                    JLabel Parabola_lable5_left4 = new JLabel(new ImageIcon(Parabola_icon5_left4.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                                                    Parabola_lable5_left4.setBounds(1150, 280 , 350, 420);
                                                                    jFrame.add(Parabola_lable5_left4);

                                                                    //самый низ4
                                                                    JLabel ParabolaFive_bot5 = new JLabel(
                                                                            "<html>Ответ:<br>" +
                                                                                    "</html>");
                                                                    ParabolaFive_bot5.setBounds(1150, 700, 100, 40);
                                                                    ParabolaFive_bot5.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot5);

                                                                    JTextField Answer4Final = new JTextField();
                                                                    Answer4Final.setBounds(1225, 714,20, 20); // кроссплатформенность
                                                                    jFrame.add(Answer4Final);

                                                                    JButton ProverkaFinal = new JButton("Проверить");
                                                                    ProverkaFinal.setFont(font_train);
                                                                    ProverkaFinal.setBackground(Color.gray);
                                                                    ProverkaFinal.setForeground(Color.WHITE);
                                                                    ProverkaFinal.setFocusPainted(false);
                                                                    ProverkaFinal.setBounds( 25, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                                                    ProverkaFinal.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                                                    jFrame.add(ProverkaFinal);

                                                                    //верно/неверно лейблы

                                                                    JLabel ParabolaFive_bot22 = new JLabel(
                                                                            "");
                                                                    ParabolaFive_bot22.setBounds(150, 714,200, 20);
                                                                    ParabolaFive_bot22.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot22);

                                                                    JLabel ParabolaFive_bot33 = new JLabel(
                                                                            "");
                                                                    ParabolaFive_bot33.setBounds(515, 714,200, 20);
                                                                    ParabolaFive_bot33.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot33);

                                                                    JLabel ParabolaFive_bot44 = new JLabel(
                                                                            "");
                                                                    ParabolaFive_bot44.setBounds(910, 714,200, 20);
                                                                    ParabolaFive_bot44.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot44);

                                                                    JLabel ParabolaFive_bot55 = new JLabel(
                                                                            "");
                                                                    ParabolaFive_bot55.setBounds(1275, 714,200, 20);
                                                                    ParabolaFive_bot55.setFont(font_ParabolaOn);
                                                                    jFrame.add(ParabolaFive_bot55);

                                                                    Answer1Final.setText("+");
                                                                    Answer2Final.setText("-");
                                                                    Answer3Final.setText("-2");
                                                                    Answer4Final.setText("1.5");

                                                                    JButton ParabolaEnd = new JButton("Завершить");
                                                                    ParabolaEnd.setFont(font_train);
                                                                    ParabolaEnd.setBackground(Color.gray);
                                                                    ParabolaEnd.setForeground(Color.WHITE);
                                                                    ParabolaEnd.setFocusPainted(false);
                                                                    ParabolaEnd.setBounds(1350, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                                                    ParabolaEnd.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                                                    jFrame.add(ParabolaEnd);

                                                                    ProverkaFinal.addActionListener(new ActionListener() {
                                                                        @Override
                                                                        public void actionPerformed(ActionEvent e) {
                                                                            Boolean Koef_AandB = true;

                                                                            if (!Answer1Final.getText().isEmpty() && Answer1Final.getText().equals("+")) {//Считываем введенные кэфы пользователем
                                                                                ParabolaFive_bot22.setText("Верно!");
                                                                            } else {
                                                                                ParabolaFive_bot22.setText("Неверно!");
                                                                                Koef_AandB = false;
                                                                            }
                                                                            if (!Answer2Final.getText().isEmpty() && Answer2Final.getText().equals("-")) {//Считываем введенные кэфы пользователем
                                                                                ParabolaFive_bot33.setText("Верно!");
                                                                            } else {
                                                                                ParabolaFive_bot33.setText("Неверно!");
                                                                                Koef_AandB = false;
                                                                            }
                                                                            if (!Answer3Final.getText().isEmpty() && Integer.parseInt(Answer3Final.getText()) == -2) {//Считываем введенные кэфы пользователем
                                                                                ParabolaFive_bot44.setText("Верно!");
                                                                            } else {
                                                                                ParabolaFive_bot44.setText("Неверно!");
                                                                                Koef_AandB = false;
                                                                            }
                                                                            if (!Answer4Final.getText().isEmpty() && Double.parseDouble(Answer4Final.getText()) == 1.5) {//Считываем введенные кэфы пользователем
                                                                                ParabolaFive_bot55.setText("Верно!");
                                                                            } else {
                                                                                ParabolaFive_bot55.setText("Неверно!");
                                                                                Koef_AandB = false;
                                                                            }

                                                                            if (Koef_AandB) {

                                                                                ParabolaEnd.addActionListener(new ActionListener() {
                                                                                    @Override
                                                                                    public void actionPerformed(ActionEvent e) {
                                                                                        jFrame.getContentPane().removeAll();
                                                                                        jFrame.repaint();

                                                                                        jFrame.setVisible(true);
                                                                                        StartMenu();
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    });

                                                                    jFrame.setVisible(true);
                                                                }
                                                            });

                                                            jFrame.setVisible(true);
                                                        }
                                                    });
                                                }
                                            }
                                        });

                                        jFrame.setVisible(true);
                                    }
                                });

                                jFrame.setVisible(true);
                            }
                        });

                        jFrame.setVisible(true);
                    }
                });

                //Прямая Тренинг
                JButton Train_Line = new JButton("Прямая");
                Train_Line.setFont(font_train);
                Train_Line.setBackground(new Color(173,216,230));
                Train_Line.setForeground(Color.WHITE);
                Train_Line.setFocusPainted(false);
                Train_Line.setBounds( 680, 125, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                Train_Line.setBorder(BorderFactory.createRaisedBevelBorder());// тени для кнопки
                Train_Line.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.getContentPane().removeAll();
                        jFrame.repaint();
                        jFrame.setTitle("Прямая");

                        JLabel LineOne = new JLabel(
                                "<html>Линейная функция — функция вида <br>" +
                                        "y = kx + b (для функций одной переменной).<br>" +
                                        "Основное свойство линейных функций: <br>" +
                                        "приращение функции пропорционально  <br>" +
                                        "приращению аргумента. То есть функция <br>" +
                                        "является обобщением прямой <br>" +
                                        "пропорциональности.<br>" +
                                        "<br>" +
                                        "Графиком линейной функции является прямая, <br>" +
                                        "с чем и связано её название.<br>" +
                                        "<br>Приведем пример функции y = x</html>");
                        LineOne.setBounds(20, 52, 760, 470);
                        Font font_ParabolaOne = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/40000);
                        LineOne.setFont(font_ParabolaOne);
                        jFrame.add(LineOne);

                        ImageIcon Line_icon1_left = new ImageIcon("img/Line1.png");

                        JLabel Line_lable1_left = new JLabel(new ImageIcon(Line_icon1_left.getImage().getScaledInstance(620, 650, Image.SCALE_SMOOTH)));
                        Line_lable1_left.setBounds(dimension.width/2 + 40, dimension.height/2 - 370, 620, 650);
                        jFrame.add(Line_lable1_left);

                        JButton NextOne = new JButton("Далее");
                        NextOne.setFont(font_train);
                        NextOne.setBackground(Color.gray);
                        NextOne.setForeground(Color.WHITE);
                        NextOne.setFocusPainted(false);
                        NextOne.setBounds( 20, 670, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                        NextOne.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                        jFrame.add(NextOne);
                        NextOne.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                jFrame.getContentPane().removeAll();
                                jFrame.repaint();

                                JLabel LineTwo = new JLabel(
                                        "<html>Линейная функция — это функция вида y = kx + b, где х — независимая переменная, <br>" +
                                                "k, b — некоторые числа. При этом k — угловой коэффициент, b — свободный коэффициент.<br>" +
                                                "Геометрический смысл коэффициента b — длина отрезка, который отсекает прямая по оси <br>" +
                                                "OY, считая от начала координат. Геометрический смысл коэффициента k — угол наклона<br>" +
                                                "прямой к положительному направлению оси OX, считается против часовой стрелки.<br>" +
                                                "Если известно конкретное значение х, можно вычислить соответствующее значение у.<br>" +
                                                "Нам дана функция: у = 0,5х - 2. Значит:<br>" +
                                                "если х = 0, то у = -2; если х = 2, то у = -1; если х = 4, то у = 0 и т. д.<br>" +
                                                "Графиком линейной функции является прямая. Для ее построения достаточно двух точек, <br>" +
                                                "координаты которых удовлетворяют уравнению функции. Угловой коэффициент отвечает <br>" +
                                                "за угол наклона прямой, свободный коэффициент — за точку пересечения графика с осью <br>" +
                                                "ординат. k и b — это числовые коэффициенты функции. На их месте могут стоять любые <br>" +
                                                "числа: положительные, отрицательные или дроби.<br>" +
                                                "</html>");
                                LineTwo.setBounds(20, 0, 850, 350);
                                Font font_ParabolaTwo = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/80000);
                                LineTwo.setFont(font_ParabolaTwo);
                                jFrame.add(LineTwo);

                                //размеры у d и b должны совпадать!!! делаем на пустом листе в поверпоинте там формулы и тд и добавляем с кайфом, а можно в начале прям слайды добавить
                                ImageIcon Line_icon2_left = new ImageIcon("img/Line2_l.png");

                                JLabel Line_lable_left = new JLabel(new ImageIcon(Line_icon2_left.getImage().getScaledInstance(680, 420, Image.SCALE_SMOOTH)));
                                Line_lable_left.setBounds(22, 330 , 680, 420);
                                jFrame.add(Line_lable_left);

                                //right

                                JLabel LineTwo2 = new JLabel(
                                        "<html>Свойства линейной функции<br>" +
                                                "1. Область определения функции — множество всех действительных чисел.<br>" +
                                                "2. Множеством значений функции является множество всех действительных чисел.<br>" +
                                                "3.График линейной функции — прямая. Для построения прямой достаточно знать две точки.  <br>" +
                                                "Положение прямой на координатной плоскости зависит от значений коэффициентов k и b.<br>" +
                                                "4. Функция не имеет ни наибольшего, ни наименьшего значений.<br>" +
                                                "5. График функции пересекает оси координат:<br>" +
                                                "ось абсцисс ОХ — в точке (−b/k; 0); ось ординат OY — в точке (0; b).<br>" +
                                                "6. Функция монотонно возрастает на области определения при k>0 и монотонно убывает при 0>k.<br>" +
                                                "7. При k > 0 функция принимает отрицательные значения на промежутке (−∞; −b/k) и положительные <br>" +
                                                "значения на промежутке (−b/k; +∞). При k < 0 функция принимает отрицательные значения на <br>" +
                                                "промежутке (−b/k; +∞) и положительные значения на промежутке (−∞; −b/k).<br>" +
                                                "8. Коэффициент k характеризует угол, который образует прямая с положительным направлением OX.<br>" +
                                                "</html>");
                                LineTwo2.setBounds(720, 0, 850, 350);
                                LineTwo2.setFont(font_ParabolaTwo);
                                jFrame.add(LineTwo2);

                                ImageIcon Line_icon2_right = new ImageIcon("img/Line2_l2.png");

                                JLabel Line_lable_right = new JLabel(new ImageIcon(Line_icon2_right.getImage().getScaledInstance(780, 420, Image.SCALE_SMOOTH)));
                                Line_lable_right.setBounds(720, 330 , 780, 420);
                                jFrame.add(Line_lable_right);

                                JButton NextTwo = new JButton("Далее");
                                NextTwo.setFont(font_train);
                                NextTwo.setBackground(Color.gray);
                                NextTwo.setForeground(Color.WHITE);
                                NextTwo.setFocusPainted(false);
                                NextTwo.setBounds( 1350, 50, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                NextTwo.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                jFrame.add(NextTwo);
                                NextTwo.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jFrame.getContentPane().removeAll();
                                        jFrame.repaint();

                                        Font font_Line = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);

                                        JLabel LineThree = new JLabel(
                                                "<html>Разберем некоторые примеры, связанные с коэффицентами k и b<br>" +
                                                        "</html>");
                                        LineThree.setBounds(315, 22, 980, 80);
                                        LineThree.setFont(font_ParabolaOne);
                                        jFrame.add(LineThree);

                                        //2 лейбл
                                        JLabel LineThree_bot = new JLabel(
                                                "<html>Определите знак коэффицента b: (ответы +/-)<br>" +
                                                        "</html>");
                                        LineThree_bot.setBounds(115, 202, 500, 40);
                                        LineThree_bot.setFont(font_Line);
                                        jFrame.add(LineThree_bot);

                                        //первая картинка слева
                                        ImageIcon Line_icon3_left = new ImageIcon("img/Line3_l.png");

                                        JLabel Line_lable3_left = new JLabel(new ImageIcon(Line_icon3_left.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Line_lable3_left.setBounds(25, 280 , 350, 420);
                                        jFrame.add(Line_lable3_left);

                                        //самый низ
                                        JLabel LineThree_bot2 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        LineThree_bot2.setBounds(25, 700, 100, 40);
                                        LineThree_bot2.setFont(font_Line);
                                        jFrame.add(LineThree_bot2);

                                        JTextField Answer1Final = new JTextField();
                                        Answer1Final.setBounds(100, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer1Final);

                                        //вторая картинка слева
                                        ImageIcon Line_icon3_left2 = new ImageIcon("img/Line3_l2.png");

                                        JLabel Line_lable3_left2 = new JLabel(new ImageIcon(Line_icon3_left2.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Line_lable3_left2.setBounds(390, 280 , 350, 420);
                                        jFrame.add(Line_lable3_left2);

                                        //самый низ2
                                        JLabel LineThree_bot3 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        LineThree_bot3.setBounds(390, 700, 100, 40);
                                        LineThree_bot3.setFont(font_Line);
                                        jFrame.add(LineThree_bot3);

                                        JTextField Answer2Final = new JTextField();
                                        Answer2Final.setBounds(465, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer2Final);

                                        //правое задание

                                        //2 лейбл справа
                                        JLabel LineThree_botR = new JLabel(
                                                "<html>Определите значение коэффицента k:<br>" +
                                                        "</html>");
                                        LineThree_botR.setBounds(875, 202, 500, 40);
                                        LineThree_botR.setFont(font_Line);
                                        jFrame.add(LineThree_botR);

                                        //третья картинка слева
                                        ImageIcon Line_icon3_left3 = new ImageIcon("img/Line3_l3.png");

                                        JLabel Line_lable3_left3 = new JLabel(new ImageIcon(Line_icon3_left3.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Line_lable3_left3.setBounds(785, 280 , 350, 420);
                                        jFrame.add(Line_lable3_left3);

                                        //самый низ3
                                        JLabel LineThree_bot4 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        LineThree_bot4.setBounds(785, 700, 100, 40);
                                        LineThree_bot4.setFont(font_Line);
                                        jFrame.add(LineThree_bot4);

                                        JTextField Answer3Final = new JTextField();
                                        Answer3Final.setBounds(860, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer3Final);

                                        //4 картинка слева
                                        ImageIcon Line_icon3_left4 = new ImageIcon("img/Line3_l4.png");

                                        JLabel Line_lable3_left4 = new JLabel(new ImageIcon(Line_icon3_left4.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                        Line_lable3_left4.setBounds(1150, 280 , 350, 420);
                                        jFrame.add(Line_lable3_left4);

                                        //самый низ4
                                        JLabel LineThree_bot5 = new JLabel(
                                                "<html>Ответ:<br>" +
                                                        "</html>");
                                        LineThree_bot5.setBounds(1150, 700, 100, 40);
                                        LineThree_bot5.setFont(font_Line);
                                        jFrame.add(LineThree_bot5);

                                        JTextField Answer4Final = new JTextField();
                                        Answer4Final.setBounds(1225, 714,20, 20); // кроссплатформенность
                                        jFrame.add(Answer4Final);

                                        JButton ProverkaFinal = new JButton("Проверить");
                                        ProverkaFinal.setFont(font_train);
                                        ProverkaFinal.setBackground(Color.gray);
                                        ProverkaFinal.setForeground(Color.WHITE);
                                        ProverkaFinal.setFocusPainted(false);
                                        ProverkaFinal.setBounds( 25, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                        ProverkaFinal.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                        jFrame.add(ProverkaFinal);

                                        //верно/неверно лейблы

                                        JLabel LineThree_bot22 = new JLabel(
                                                "");
                                        LineThree_bot22.setBounds(150, 714,200, 20);
                                        LineThree_bot22.setFont(font_Line);
                                        jFrame.add(LineThree_bot22);

                                        JLabel LineThree_bot33 = new JLabel(
                                                "");
                                        LineThree_bot33.setBounds(515, 714,200, 20);
                                        LineThree_bot33.setFont(font_Line);
                                        jFrame.add(LineThree_bot33);

                                        JLabel LineThree_bot44 = new JLabel(
                                                "");
                                        LineThree_bot44.setBounds(910, 714,200, 20);
                                        LineThree_bot44.setFont(font_Line);
                                        jFrame.add(LineThree_bot44);

                                        JLabel LineThree_bot55 = new JLabel(
                                                "");
                                        LineThree_bot55.setBounds(1275, 714,200, 20);
                                        LineThree_bot55.setFont(font_Line);
                                        jFrame.add(LineThree_bot55);

                                        Answer1Final.setText("+");
                                        Answer2Final.setText("-");
                                        Answer3Final.setText("3");
                                        Answer4Final.setText("-2");

                                        JButton LineEnd = new JButton("Завершить");
                                        LineEnd.setFont(font_train);
                                        LineEnd.setBackground(Color.gray);
                                        LineEnd.setForeground(Color.WHITE);
                                        LineEnd.setFocusPainted(false);
                                        LineEnd.setBounds(1350, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                        LineEnd.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                        jFrame.add(LineEnd);

                                        ProverkaFinal.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                Boolean Koef_AandB = true;

                                                if (!Answer1Final.getText().isEmpty() && Answer1Final.getText().equals("+")) {//Считываем введенные кэфы пользователем
                                                    LineThree_bot22.setText("Верно!");
                                                } else {
                                                    LineThree_bot22.setText("Неверно!");
                                                    Koef_AandB = false;
                                                }
                                                if (!Answer2Final.getText().isEmpty() && Answer2Final.getText().equals("-")) {//Считываем введенные кэфы пользователем
                                                    LineThree_bot33.setText("Верно!");
                                                } else {
                                                    LineThree_bot33.setText("Неверно!");
                                                    Koef_AandB = false;
                                                }
                                                if (!Answer3Final.getText().isEmpty() && Integer.parseInt(Answer3Final.getText()) == 3) {//Считываем введенные кэфы пользователем
                                                    LineThree_bot44.setText("Верно!");
                                                } else {
                                                    LineThree_bot44.setText("Неверно!");
                                                    Koef_AandB = false;
                                                }
                                                if (!Answer4Final.getText().isEmpty() && Double.parseDouble(Answer4Final.getText()) == -2) {//Считываем введенные кэфы пользователем
                                                    LineThree_bot55.setText("Верно!");
                                                } else {
                                                    LineThree_bot55.setText("Неверно!");
                                                    Koef_AandB = false;
                                                }

                                                if (Koef_AandB) {

                                                    LineEnd.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            jFrame.getContentPane().removeAll();
                                                            jFrame.repaint();

                                                            jFrame.setVisible(true);
                                                            StartMenu();
                                                        }
                                                    });
                                                }
                                            }
                                        });

                                        jFrame.setVisible(true);
                                    }
                                });



                                jFrame.setVisible(true);
                            }
                        });

                        jFrame.setVisible(true);

                    }
                });
                jFrame.add(Train_Line);

                JButton Train_Gip = new JButton("Гипербола");
                Train_Gip.setFont(font_train);
                Train_Gip.setBackground(new Color(173,216,230));
                Train_Gip.setForeground(Color.WHITE);
                Train_Gip.setFocusPainted(false);
                Train_Gip.setBounds( 680, 170, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                Train_Gip.setBorder(BorderFactory.createRaisedBevelBorder());// тени для кнопки
                Train_Gip.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.getContentPane().removeAll();
                        jFrame.repaint();
                        jFrame.setTitle("Гипербола");

                        JLabel GipOne = new JLabel(
                                "<html>Гипербола – это график функции обратной <br>" +
                                        "пропорциональности, которая в общем виде <br>" +
                                        "задается следующей формулой: y = k/x, где:<br>" +
                                        "x – независимая переменная;<br>" +
                                        "k ≠ 0;<br>" +
                                        "при k > 0 гипербола расположена в I и III <br>" +
                                        "четвертях координатной плоскости;<br>" +
                                        "при 0 > k график находится во II и IV четвертях.<br>" +
                                        "Допустим есть функция, заданная формулой:<br>" +
                                        "y = k/(x-a) + b<br>" +
                                        "x = a – это вертикальная асимптота графика <br>" +
                                        "(при a ≠ 0) вместо оси Oy ;y = b – горизонтальная <br>" +
                                        "асимптота (при b ≠ 0) вместо оси Ox.<br>" +
                                        "Приведем пример функции y = 1/x</html>");
                        GipOne.setBounds(20, 32, 760, 620);
                        Font font_ParabolaOne = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/40000);
                        GipOne.setFont(font_ParabolaOne);
                        jFrame.add(GipOne);

                        ImageIcon Gip_icon1_left = new ImageIcon("img/Gip1.png");

                        JLabel Gip_lable1_left = new JLabel(new ImageIcon(Gip_icon1_left.getImage().getScaledInstance(620, 650, Image.SCALE_SMOOTH)));
                        Gip_lable1_left.setBounds(dimension.width/2 + 40, dimension.height/2 - 370, 620, 650);
                        jFrame.add(Gip_lable1_left);

                        JButton NextOne = new JButton("Далее");
                        NextOne.setFont(font_train);
                        NextOne.setBackground(Color.gray);
                        NextOne.setForeground(Color.WHITE);
                        NextOne.setFocusPainted(false);
                        NextOne.setBounds( 20, 670, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                        NextOne.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                        jFrame.add(NextOne);
                        NextOne.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                jFrame.getContentPane().removeAll();
                                jFrame.repaint();

                                JLabel GipTwo = new JLabel(
                                        "<html>Алгоритм построения гиперболы:<br>" +
                                                "Дана функция y = 4/x. Построим ее график.<br>" +
                                                "Решение:<br>" +
                                                "Так как k > 0, следовательно, гипербола будет находиться в I и III координатных четвертях.<br>" +
                                                "Чтобы построить график, сначала нужно составить таблицу соответствия значений x и y.<br>" +
                                                "То есть мы берем конкретное значение x, подставляем его в формулу функции и получаем y<br>" +
                                                "x = 0.5, y = 8; x = 1, y = 4; x = 2, y = 2; x = 4, y = 8; x = 8, y = 0.5<br>" +
                                                "Теперь отмечаем найденные точки на координатной плоскости и соединяем их плавной <br>" +
                                                "линией, которая будет стремиться к осям координат. В итоге получится ветвь гиперболы, <br>" +
                                                "расположенная в первой четверти. Чтобы построить ветвь в третьей четверти, вместо x <br>" +
                                                "в формулу подставляем -x. Так мы вычислим значения y.<br>" +
                                                "x = -0.5, y = -8; x = -1, y = -4; x = -2, y = -2; x = -4, y = -8; x = -8, y = -0.5<br>" +
                                                "Соединив полученные точки имеем следующий результат. На этом построение завершено.<br>" +
                                                "</html>");
                                GipTwo.setBounds(20, 0, 850, 350);
                                Font font_GipTwo = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/80000);
                                GipTwo.setFont(font_GipTwo);
                                jFrame.add(GipTwo);

                                //размеры у d и b должны совпадать!!! делаем на пустом листе в поверпоинте там формулы и тд и добавляем с кайфом, а можно в начале прям слайды добавить
                                ImageIcon Gip_icon2_left = new ImageIcon("img/Gip2_l.png");

                                JLabel Gip_lable_left = new JLabel(new ImageIcon(Gip_icon2_left.getImage().getScaledInstance(680, 420, Image.SCALE_SMOOTH)));
                                Gip_lable_left.setBounds(22, 330 , 680, 420);
                                jFrame.add(Gip_lable_left);

                                //right

                                JLabel GipTwo2 = new JLabel(
                                        "<html>Пример 2<br>" +
                                                "Рассмотренный ранее пример был одним из самых простых (без смещения асимптот).<br>" +
                                                "Давайте усложним задачу и построим гиперболу, заданную функцией ниже:<br>" +
                                                "y = -2/(x-3) + 4<br>" +
                                                "Решение:<br>" +
                                                "Так как 0 > k, график будет располагаться во второй и четвертой четвертях.<br>" +
                                                "Теперь определяемся с асимптотами, в нашем случае это x = 3 и y = 4.<br>" +
                                                "ось абсцисс ОХ — в точке (−b/k; 0); ось ординат OY — в точке (0; b).<br>" +
                                                "Составим таблицу соответствия значений x и y.<br>" +
                                                "x = -1, y = 4.5; x = 1, y = 5; x = 2, y = 6; x = 2.5, y = 8;<br>" +
                                                "x = 3.5, y = 0; x = 4, y = 2; x = 5, y = 3; x = 7, y = 3.5;<br>" +
                                                "Остается только нанести рассчитанные точки на координатную плоскость и <br>" +
                                                "соединить их плавными линиями.<br>" +
                                                "</html>");
                                GipTwo2.setBounds(720, 0, 850, 350);
                                GipTwo2.setFont(font_GipTwo);
                                jFrame.add(GipTwo2);

                                ImageIcon Gip_icon2_right = new ImageIcon("img/Gip2_l2.png");

                                JLabel Gip_lable_right = new JLabel(new ImageIcon(Gip_icon2_right.getImage().getScaledInstance(780, 420, Image.SCALE_SMOOTH)));
                                Gip_lable_right.setBounds(720, 330 , 780, 420);
                                jFrame.add(Gip_lable_right);

                                JButton NextTwo = new JButton("Далее");
                                NextTwo.setFont(font_train);
                                NextTwo.setBackground(Color.gray);
                                NextTwo.setForeground(Color.WHITE);
                                NextTwo.setFocusPainted(false);
                                NextTwo.setBounds( 1350, 262, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                NextTwo.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                jFrame.add(NextTwo);
                                NextTwo.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jFrame.getContentPane().removeAll();
                                        jFrame.repaint();

                                        JLabel GipThree = new JLabel(
                                                "<html>Свойства функции y = k/x при k > 0<br>" +
                                                        "1. Область определения функции - все числа, кроме нуля, то есть х≠0.<br>" +
                                                        "2. у > 0 при х > 0; 0 > y при 0 > x.<br>" +
                                                        "3. Промежутки убывания: (-∞; 0) и (0; +∞).<br>" +
                                                        "4. Функция не ограничена ни снизу, ни сверху.<br>" +
                                                        "5. Наименьшего значения нет; наибольшего значения нет.<br>" +
                                                        "6. Функция непрерывна на промежутках (-∞; 0) и (0; +∞) и имеет разрыв при х = 0.<br>" +
                                                        "7. Область значений функции: (-∞; 0) U (0; +∞).<br>" +
                                                        "</html>");
                                        GipThree.setBounds(20, 0, 850, 300);
                                        Font font_GipThree = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/70000);
                                        GipThree.setFont(font_GipThree);
                                        jFrame.add(GipThree);

                                        //размеры у d и b должны совпадать!!! делаем на пустом листе в поверпоинте там формулы и тд и добавляем с кайфом, а можно в начале прям слайды добавить
                                        ImageIcon Gip_icon3_left = new ImageIcon("img/GipF.png");

                                        JLabel Gip_lable3_left = new JLabel(new ImageIcon(Gip_icon3_left.getImage().getScaledInstance(690, 420, Image.SCALE_SMOOTH)));
                                        Gip_lable3_left.setBounds(22, 280 , 690, 420);
                                        jFrame.add(Gip_lable3_left);

                                        //right

                                        JLabel GipThree2 = new JLabel(
                                                "<html>Свойства функции y = k/x при 0 > k<br>" +
                                                        "1. Область определения функции - все числа, кроме нуля, то есть х≠0.<br>" +
                                                        "2. у > 0 при 0 > x; 0 > y при x > 0.<br>" +
                                                        "3. Возрастает на: (-∞; 0) и (0; +∞).<br>" +
                                                        "4. Функция не ограничена ни снизу, ни сверху.<br>" +
                                                        "5. Наименьшего значения нет; наибольшего значения нет.<br>" +
                                                        "6. Функция непрерывна на промежутках (-∞; 0) и (0; +∞) и имеет разрыв при х = 0.<br>" +
                                                        "7. Область значений функции: (-∞; 0) U (0; +∞).<br>" +
                                                        "</html>");
                                        GipThree2.setBounds(740, 0, 850, 300);
                                        GipThree2.setFont(font_GipThree);
                                        jFrame.add(GipThree2);

                                        ImageIcon Gip_icon3_right = new ImageIcon("img/GipF2.png");

                                        JLabel Gip_lable3_right = new JLabel(new ImageIcon(Gip_icon3_right.getImage().getScaledInstance(750, 420, Image.SCALE_SMOOTH)));
                                        Gip_lable3_right.setBounds(740, 280 , 750, 420);
                                        jFrame.add(Gip_lable3_right);

                                        JButton NextThree = new JButton("Далее");
                                        NextThree.setFont(font_train);
                                        NextThree.setBackground(Color.gray);
                                        NextThree.setForeground(Color.WHITE);
                                        NextThree.setFocusPainted(false);
                                        NextThree.setBounds( 1340, 710, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                        NextThree.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                        jFrame.add(NextThree);
                                        NextThree.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                jFrame.getContentPane().removeAll();
                                                jFrame.repaint();

                                                Font font_Line = new Font("Times New Roman", Font.BOLD, dimension.height*dimension.width/60000);

                                                JLabel GipFour = new JLabel(
                                                        "<html>Разберем некоторые примеры, связанные с коэффицентами k, a и b<br>" +
                                                                "</html>");
                                                GipFour.setBounds(245, 22, 1010, 80);
                                                GipFour.setFont(font_ParabolaOne);
                                                jFrame.add(GipFour);

                                                //2 лейбл
                                                JLabel GipFour_bot = new JLabel(
                                                        "<html>Определите значения сдвига функции сначала по x, затем по y:<br>" +
                                                                "</html>");
                                                GipFour_bot.setBounds(50, 202, 650, 40);
                                                GipFour_bot.setFont(font_Line);
                                                jFrame.add(GipFour_bot);

                                                //первая картинка слева
                                                ImageIcon Gip_icon4_left = new ImageIcon("img/GipFinal1.png");

                                                JLabel Gip_lable4_left = new JLabel(new ImageIcon(Gip_icon4_left.getImage().getScaledInstance(715, 420, Image.SCALE_SMOOTH)));
                                                Gip_lable4_left.setBounds(25, 280 , 715, 420);
                                                jFrame.add(Gip_lable4_left);

                                                //самый низ
                                                JLabel GipFour_bot2 = new JLabel(
                                                        "<html>Ответ:<br>" +
                                                                "</html>");
                                                GipFour_bot2.setBounds(25, 700, 100, 40);
                                                GipFour_bot2.setFont(font_Line);
                                                jFrame.add(GipFour_bot2);

                                                JTextField Answer1Final = new JTextField();
                                                Answer1Final.setBounds(100, 714,20, 20); // кроссплатформенность
                                                jFrame.add(Answer1Final);

                                                //самый низ2
                                                JLabel GipFour_bot3 = new JLabel(
                                                        "<html>Ответ:<br>" +
                                                                "</html>");
                                                GipFour_bot3.setBounds(390, 700, 100, 40);
                                                GipFour_bot3.setFont(font_Line);
                                                jFrame.add(GipFour_bot3);

                                                JTextField Answer2Final = new JTextField();
                                                Answer2Final.setBounds(465, 714,20, 20); // кроссплатформенность
                                                jFrame.add(Answer2Final);

                                                //правое задание

                                                //2 лейбл справа
                                                JLabel GipFour_botR = new JLabel(
                                                        "<html>Определите значение коэффицента k:<br>" +
                                                                "</html>");
                                                GipFour_botR.setBounds(930, 202, 500, 40);
                                                GipFour_botR.setFont(font_Line);
                                                jFrame.add(GipFour_botR);

                                                //вторая картинка слева
                                                ImageIcon Gip_icon3_left3 = new ImageIcon("img/GipFinal2.png");

                                                JLabel Gip_lable4_left3 = new JLabel(new ImageIcon(Gip_icon3_left3.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                                Gip_lable4_left3.setBounds(785, 280 , 350, 420);
                                                jFrame.add(Gip_lable4_left3);

                                                //самый низ3
                                                JLabel GipFour_bot4 = new JLabel(
                                                        "<html>Ответ:<br>" +
                                                                "</html>");
                                                GipFour_bot4.setBounds(785, 700, 100, 40);
                                                GipFour_bot4.setFont(font_Line);
                                                jFrame.add(GipFour_bot4);

                                                JTextField Answer3Final = new JTextField();
                                                Answer3Final.setBounds(860, 714,20, 20); // кроссплатформенность
                                                jFrame.add(Answer3Final);

                                                //4 картинка слева
                                                ImageIcon Gip_icon4_left4 = new ImageIcon("img/GipFinal3.png");

                                                JLabel Gip_lable4_left4 = new JLabel(new ImageIcon(Gip_icon4_left4.getImage().getScaledInstance(380, 420, Image.SCALE_SMOOTH)));
                                                Gip_lable4_left4.setBounds(1150, 280 , 350, 420);
                                                jFrame.add(Gip_lable4_left4);

                                                //самый низ4
                                                JLabel GipFour_bot5 = new JLabel(
                                                        "<html>Ответ:<br>" +
                                                                "</html>");
                                                GipFour_bot5.setBounds(1150, 700, 100, 40);
                                                GipFour_bot5.setFont(font_Line);
                                                jFrame.add(GipFour_bot5);

                                                JTextField Answer4Final = new JTextField();
                                                Answer4Final.setBounds(1225, 714,20, 20); // кроссплатформенность
                                                jFrame.add(Answer4Final);

                                                JButton ProverkaFinal = new JButton("Проверить");
                                                ProverkaFinal.setFont(font_train);
                                                ProverkaFinal.setBackground(Color.gray);
                                                ProverkaFinal.setForeground(Color.WHITE);
                                                ProverkaFinal.setFocusPainted(false);
                                                ProverkaFinal.setBounds( 25, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                                ProverkaFinal.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                                jFrame.add(ProverkaFinal);

                                                //верно/неверно лейблы

                                                JLabel GipFour_bot22 = new JLabel(
                                                        "");
                                                GipFour_bot22.setBounds(150, 714,200, 20);
                                                GipFour_bot22.setFont(font_Line);
                                                jFrame.add(GipFour_bot22);

                                                JLabel GipFour_bot33 = new JLabel(
                                                        "");
                                                GipFour_bot33.setBounds(515, 714,200, 20);
                                                GipFour_bot33.setFont(font_Line);
                                                jFrame.add(GipFour_bot33);

                                                JLabel GipFour_bot44 = new JLabel(
                                                        "");
                                                GipFour_bot44.setBounds(910, 714,200, 20);
                                                GipFour_bot44.setFont(font_Line);
                                                jFrame.add(GipFour_bot44);

                                                JLabel GipFour_bot55 = new JLabel(
                                                        "");
                                                GipFour_bot55.setBounds(1275, 714,200, 20);
                                                GipFour_bot55.setFont(font_Line);
                                                jFrame.add(GipFour_bot55);

                                                Answer1Final.setText("1");
                                                Answer2Final.setText("2");
                                                Answer3Final.setText("-2");
                                                Answer4Final.setText("3");

                                                JButton LineEnd = new JButton("Завершить");
                                                LineEnd.setFont(font_train);
                                                LineEnd.setBackground(Color.gray);
                                                LineEnd.setForeground(Color.WHITE);
                                                LineEnd.setFocusPainted(false);
                                                LineEnd.setBounds(1350, 740, 150, 40); //КРОССПЛАТФОРМЕННОСТЬ
                                                LineEnd.setBorder(BorderFactory.createRaisedBevelBorder()); // тени для кнопки
                                                jFrame.add(LineEnd);

                                                ProverkaFinal.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        Boolean Koef_AandB = true;

                                                        if (!Answer1Final.getText().isEmpty() && Integer.parseInt(Answer1Final.getText()) == 1) {//Считываем введенные кэфы пользователем
                                                            GipFour_bot22.setText("Верно!");
                                                        } else {
                                                            GipFour_bot22.setText("Неверно!");
                                                            Koef_AandB = false;
                                                        }
                                                        if (!Answer2Final.getText().isEmpty() && Integer.parseInt(Answer2Final.getText()) == 2) {//Считываем введенные кэфы пользователем
                                                            GipFour_bot33.setText("Верно!");
                                                        } else {
                                                            GipFour_bot33.setText("Неверно!");
                                                            Koef_AandB = false;
                                                        }
                                                        if (!Answer3Final.getText().isEmpty() && Integer.parseInt(Answer3Final.getText()) == -2) {//Считываем введенные кэфы пользователем
                                                            GipFour_bot44.setText("Верно!");
                                                        } else {
                                                            GipFour_bot44.setText("Неверно!");
                                                            Koef_AandB = false;
                                                        }
                                                        if (!Answer4Final.getText().isEmpty() && Double.parseDouble(Answer4Final.getText()) == 3) {//Считываем введенные кэфы пользователем
                                                            GipFour_bot55.setText("Верно!");
                                                        } else {
                                                            GipFour_bot55.setText("Неверно!");
                                                            Koef_AandB = false;
                                                        }

                                                        if (Koef_AandB) {

                                                            LineEnd.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    jFrame.getContentPane().removeAll();
                                                                    jFrame.repaint();

                                                                    jFrame.setVisible(true);
                                                                    StartMenu();
                                                                }
                                                            });
                                                        }
                                                    }
                                                });

                                                jFrame.setVisible(true);
                                            }
                                        });

                                        jFrame.setVisible(true);

                                    }
                                });

                                jFrame.setVisible(true);
                            }
                        });
                        jFrame.setVisible(true);
                    }
                });
                jFrame.add(Train_Gip);

                jFrame.setVisible(true);

            }
        });
        jFrame.add(Training);
        jFrame.setLayout(null); // прекращение потока, для корректного отображения пользователю компонентов

        JButton Calculator = new JButton("Калькулятор");
        Calculator.setFont(font);
        Calculator.setBounds(dimension.width/2 - dimension.width*28/512, dimension.height/6 - dimension.height*5/864, dimension.width*28/256, dimension.height*463/10000);
        Calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.repaint();

                jFrame.setTitle("Калькулятор");

                //XYSeries — это класс в Java, который представляет последовательность из нуля или более элементов данных в форме (x, y).
                XYSeries func = new XYSeries("f(x)"); //
                XYSeries func_gip = new XYSeries("gip");
                XYSeries Ox = new XYSeries("Ox");
                XYSeries Oy = new XYSeries("Oy");

                //XYDataset — это интерфейс, с помощью которого можно получить доступ к данным в виде элементов (x, y).
                XYDataset xyDataset = new XYSeriesCollection();
                ((XYSeriesCollection) xyDataset).addSeries(func);
                ((XYSeriesCollection) xyDataset).addSeries(Ox);
                ((XYSeriesCollection) xyDataset).addSeries(Oy);
                ((XYSeriesCollection) xyDataset).addSeries(func_gip);

                for (float x = -100; x < 100; x += 0.1) { // заполняем массив точками графика, в данном случае это Ox Oy
                    Ox.add(x, 0);
                    Oy.add(0, x);
                }

                //Создание графика типа XYLineChart с заголовком "schedule", осью x "x", осью y "y".
                JFreeChart chart = ChartFactory.createXYLineChart("schedule", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);


                // XYPlot — библиотека, написанная на Java, которая рисует XY-графики на основе любых данных, имеющих значения X и Y.
                XYPlot plot = chart.getXYPlot();
                //Извлечение оси x (DomainAxis) из графика.
                NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
                //Извлечение оси y (RangeAxis) из графика.
                NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

                // Устанавливаем нужные диапазоны значений для осей x и y
                xAxis.setRange(-15.0, 15.0);
                yAxis.setRange(-10.0, 10.0);

                // Настройка жирных осей X и Y
                xAxis.setAxisLineStroke(new BasicStroke(2.0f));
                xAxis.setAxisLinePaint(java.awt.Color.BLACK);
                yAxis.setAxisLineStroke(new BasicStroke(2.0f));
                yAxis.setAxisLinePaint(java.awt.Color.BLACK);

                // Настройка толщины линии каждого графика
                plot.getRenderer().setSeriesStroke(0, new BasicStroke(2.0f)); // Толщина для серии 1
                plot.getRenderer().setSeriesPaint(0, Color.cyan); // Цвет для серии 1
                plot.getRenderer().setSeriesStroke(1, new BasicStroke(1.5f)); // Толщина для серии 2
                plot.getRenderer().setSeriesPaint(1, Color.black); // Цвет для серии 2
                plot.getRenderer().setSeriesStroke(2, new BasicStroke(1.5f)); // Толщина для серии 3
                plot.getRenderer().setSeriesPaint(2, Color.BLACK); // Цвет для серии 3
                plot.getRenderer().setSeriesStroke(3, new BasicStroke(2.0f)); // Толщина для серии 3
                plot.getRenderer().setSeriesPaint(3, Color.cyan); // Цвет для серии 3

                // создаётся панель для отображения конкретного графика chart.
                ChartPanel chartPanel = new ChartPanel(chart);

                //Поле, чтобы выводить ошибки ввода пользователя
                JLabel problemUser = new JLabel("");
                problemUser.setBounds(0, 700,dimension.width*45/384, dimension.height*15/432 );
                problemUser.setForeground(Color.red);
                problemUser.setFont(new Font("Courier New", Font.BOLD, dimension.height*dimension.width/87000));
                jFrame.add(problemUser);

                //PARABOLA

                JLabel label_Parabola = new JLabel(" ( x+ )^2+ x+");
                label_Parabola.setBounds(0, 35,dimension.width*45/384, dimension.height*15/432 );
                label_Parabola.setFont(font_func);
                jFrame.add(label_Parabola);

                JTextField Parabola_A = new JTextField();
                Parabola_A.setBounds(4, 42,15, 17); // кроссплатформенность
                Parabola_A.setToolTipText("Введите коэффицент a");
                jFrame.add(Parabola_A);

                JTextField Parabola_PriX = new JTextField();
                Parabola_PriX.setBounds(25, 42,15, 17); // кроссплатформенность
                Parabola_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(Parabola_PriX);

                JTextField Parabola_D = new JTextField();
                Parabola_D.setBounds(68, 42,15, 17); // кроссплатформенность
                Parabola_D.setToolTipText("Введите коэффицент d");
                jFrame.add(Parabola_D);

                JTextField Parabola_B = new JTextField();
                Parabola_B.setBounds(135, 42,15, 17); // кроссплатформенность
                Parabola_B.setToolTipText("Введите коэффицент b");
                jFrame.add(Parabola_B);

                JTextField Parabola_C = new JTextField();
                Parabola_C.setBounds(176, 42,15, 17); // кроссплатформенность
                Parabola_C.setToolTipText("Введите коэффицент c");
                jFrame.add(Parabola_C);

                JButton Calc_Parabola = new JButton("Парабола");
                Calc_Parabola.setFont(font);
                Calc_Parabola.setBackground(new Color(59, 89, 182));
                Calc_Parabola.setForeground(Color.WHITE);
                Calc_Parabola.setFocusPainted(false);
                Calc_Parabola.setBounds( 0, 0, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_Parabola.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Parabola_koefA = Double.parseDouble(Parabola_A.getText());//Считываем введенные кэфы пользователем
                            Parabola_koefPriX = Double.parseDouble(Parabola_PriX.getText());
                            Parabola_koefD = Double.parseDouble(Parabola_D.getText());
                            Parabola_koefB = Double.parseDouble(Parabola_B.getText());
                            Parabola_koefC = Double.parseDouble(Parabola_C.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.1) {
                                func.add(x, Parabola_koefA *Math.pow(Parabola_koefPriX*x + Parabola_koefD, 2) + Parabola_koefB * x + Parabola_koefC);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }

                    }
                });

                //SQRT

                JLabel label_Sqrt = new JLabel(" √( x+ )+");
                label_Sqrt.setBounds(0, 105,dimension.width*45/384, dimension.height*15/432 );
                label_Sqrt.setFont(font_func);
                jFrame.add(label_Sqrt);

                JTextField Sqrt_K = new JTextField();
                Sqrt_K.setBounds(2, 112,15, 17); // кроссплатформенность
                Sqrt_K.setToolTipText("Введите коэффицент k при sqrt");
                jFrame.add(Sqrt_K);

                JTextField Sqrt_PriX = new JTextField();
                Sqrt_PriX.setBounds(40, 112,15, 17); // кроссплатформенность
                Sqrt_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(Sqrt_PriX);

                JTextField Sqrt_D = new JTextField();
                Sqrt_D.setBounds(81, 112,15, 17); // кроссплатформенность
                Sqrt_D.setToolTipText("Введите коэффицент d");
                jFrame.add(Sqrt_D);

                JTextField Sqrt_B = new JTextField();
                Sqrt_B.setBounds(122, 112,15, 17); // кроссплатформенность
                Sqrt_B.setToolTipText("Введите коэффицент b");
                jFrame.add(Sqrt_B);

                JButton Calc_sqrt = new JButton("Корень");
                Calc_sqrt.setBounds( 0, 70, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_sqrt.setFont(font);
                Calc_sqrt.setBackground(Color.black);
                Calc_sqrt.setForeground(Color.WHITE);
                Calc_sqrt.setFocusPainted(false);
                Calc_sqrt.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Sqrt_koefK = Double.parseDouble(Sqrt_K.getText());//Считываем введенные кэфы пользователем
                            Sqrt_koefB = Double.parseDouble(Sqrt_B.getText());
                            Sqrt_koefPriX = Double.parseDouble(Sqrt_PriX.getText());
                            Sqrt_koefD = Double.parseDouble(Sqrt_D.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.05) {
                                func.add(x, Sqrt_koefK * Math.sqrt(Sqrt_koefPriX*x + Sqrt_koefD) + Sqrt_koefB);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }
                    }
                });

                //LINE

                JLabel label_line = new JLabel(" x+");
                label_line.setBounds(7, 175,dimension.width*45/384, dimension.height*15/432 );
                label_line.setFont(font_func);
                jFrame.add(label_line);

                JTextField Line_K = new JTextField();
                Line_K.setBounds(5, 182,15, 17); // кроссплатформенность
                Line_K.setToolTipText("Введите коэффицент k");
                jFrame.add(Line_K);

                JTextField Line_B = new JTextField();
                Line_B.setBounds(48, 182,15, 17); // кроссплатформенность
                Line_B.setToolTipText("Введите коэффицент b");
                jFrame.add(Line_B);

                JButton Calc_Line = new JButton("Прямая");
                Calc_Line.setBounds( 0, 140, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_Line.setFont(font);
                Calc_Line.setBackground(Color.black);
                Calc_Line.setForeground(Color.WHITE);
                Calc_Line.setFocusPainted(false);
                Calc_Line.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try{
                            Line_koefK = Double.parseDouble(Line_K.getText());//Считываем введенные кэфы пользователем
                            Line_koefB = Double.parseDouble(Line_B.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.1) {
                                func.add(x, Line_koefK * x + Line_koefB);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }
                    }
                });

                //LOGARIFM

                JLabel label_Log = new JLabel(" log ( x+ )+");
                label_Log.setBounds(3, 245,dimension.width*45/384, dimension.height*15/432 );
                label_Log.setFont(font_func);
                jFrame.add(label_Log);

                JTextField Log_K = new JTextField();
                Log_K.setBounds(3, 252,15, 17); // кроссплатформенность
                Log_K.setToolTipText("Введите коэффицент k при log");
                jFrame.add(Log_K);

                JTextField Log_A = new JTextField();
                Log_A.setBounds(57, 260,15, 17); // кроссплатформенность
                Log_A.setToolTipText("Введите основание логарифма");
                jFrame.add(Log_A);

                JTextField Log_PriX = new JTextField();
                Log_PriX.setBounds(83, 252,15, 17); // кроссплатформенность
                Log_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(Log_PriX);

                JTextField Log_D = new JTextField();
                Log_D.setBounds(125, 252,15, 17); // кроссплатформенность
                Log_D.setToolTipText("Введите коэффицент d");
                jFrame.add(Log_D);

                JTextField Log_B = new JTextField();
                Log_B.setBounds(167, 252,15, 17); // кроссплатформенность
                Log_B.setToolTipText("Введите коэффицент b");
                jFrame.add(Log_B);

                JButton Calc_log = new JButton("Логарифм");
                Calc_log.setBounds( 0, 210, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_log.setFont(font);
                Calc_log.setBackground(Color.black);
                Calc_log.setForeground(Color.WHITE);
                Calc_log.setFocusPainted(false);
                Calc_log.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(Log_A.getText().equals("e")){
                            Log_Osnovanie =2.71828;
                        }
                        else{
                            Log_Osnovanie = Double.parseDouble(Log_A.getText());//Считываем введенные кэфы пользователем
                        }
                        try{
                            Log_KoefB = Double.parseDouble(Log_B.getText());
                            Log_KoefK = Double.parseDouble(Log_K.getText());
                            Log_KoefPriX = Double.parseDouble(Log_PriX.getText());
                            Log_KoefD = Double.parseDouble(Log_D.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.1) {
                                func.add(x,  Log_KoefK * Math.log(Log_KoefPriX * x + Log_KoefD)/Math.log(Log_Osnovanie) + Log_KoefB);
                                System.out.println(Log_KoefK * Math.log(x)/Math.log(Log_Osnovanie) + Log_KoefB);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }

                    }
                });

                //Giperbola

                JLabel label_Gip = new JLabel(" /( x+ )+");
                label_Gip.setBounds(4, 315,dimension.width*45/384, dimension.height*15/432 );
                label_Gip.setFont(font_func);
                jFrame.add(label_Gip);

                JTextField Giperbola_K = new JTextField();
                Giperbola_K.setBounds(3, 322,15, 17); // кроссплатформенность
                Giperbola_K.setToolTipText("Введите коэффицент k при sqrt");
                jFrame.add(Giperbola_K);

                JTextField Giperbola_PriX = new JTextField();
                Giperbola_PriX.setBounds(43, 322,15, 17); // кроссплатформенность
                Giperbola_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(Giperbola_PriX);

                JTextField Giperbola_D = new JTextField();
                Giperbola_D.setBounds(85, 322,15, 17); // кроссплатформенность
                Giperbola_D.setToolTipText("Введите коэффицент d");
                jFrame.add(Giperbola_D);

                JTextField Giperbola_B = new JTextField();
                Giperbola_B.setBounds(126, 322,15, 17); // кроссплатформенность
                Giperbola_B.setToolTipText("Введите коэффицент b");
                jFrame.add(Giperbola_B);

                JButton Calc_Gip = new JButton("Гипербола");
                Calc_Gip.setBounds( 0, 280, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_Gip.setFont(font);
                Calc_Gip.setBackground(Color.black);
                Calc_Gip.setForeground(Color.WHITE);
                Calc_Gip.setFocusPainted(false);
                Calc_Gip.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try{
                            Giper_koefK = Double.parseDouble(Giperbola_K.getText());
                            Giper_koefB = Double.parseDouble(Giperbola_B.getText());
                            Giper_koefD = Double.parseDouble(Giperbola_D.getText());
                            Giper_koefPriX = Double.parseDouble(Giperbola_PriX.getText());
                            func.clear();//очищаем фанк
                            func_gip.clear();
                            if(Giper_koefPriX > 0 ){
                                for (double x = -100; x < (-Giper_koefD / Giper_koefPriX) ; x += 0.1) {
                                    func.add(x,  Giper_koefK / (Giper_koefPriX * x + Giper_koefD) + Giper_koefB);
                                }
                                for (double x =  0.1 + (-Giper_koefD / Giper_koefPriX) ; x < 100; x += 0.1) {
                                    System.out.println(0.1 + (-Giper_koefD / Giper_koefPriX));
                                    func_gip.add(x,  Giper_koefK / (Giper_koefPriX * x +Giper_koefD) + Giper_koefB);
                                }
                            }
                            else{
                                for (float x = -100; x < -Giper_koefD/ Giper_koefPriX; x += 0.1) {
                                    func.add(x,  Giper_koefK / (Giper_koefPriX * x + Giper_koefD) + Giper_koefB);
                                }
                                for (double x =  0.1 +( - Giper_koefD / Giper_koefPriX); x < 100; x += 0.1) {
                                    func_gip.add(x,  Giper_koefK / (Giper_koefPriX * x +Giper_koefD) + Giper_koefB);
                                }
                            }
                            problemUser.setText("");
                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }

                    }
                });

                //Sinus

                JLabel label_Sinus = new JLabel(" sin( x+ )+");
                label_Sinus.setBounds(3, 385,dimension.width*45/384, dimension.height*15/432 );
                label_Sinus.setFont(font_func);
                jFrame.add(label_Sinus);

                JTextField Sinus_K = new JTextField();
                Sinus_K.setBounds(3, 392,15, 17); // кроссплатформенность
                Sinus_K.setToolTipText("Введите коэффицент k при sqrt");
                jFrame.add(Sinus_K);

                JTextField Sinus_PriX = new JTextField();
                Sinus_PriX.setBounds(69, 392,15, 17); // кроссплатформенность
                Sinus_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(Sinus_PriX);

                JTextField Sinus_D = new JTextField();
                Sinus_D.setBounds(111, 392,15, 17); // кроссплатформенность
                Sinus_D.setToolTipText("Введите коэффицент d");
                jFrame.add(Sinus_D);

                JTextField Sinus_B = new JTextField();
                Sinus_B.setBounds(152, 392,15, 17); // кроссплатформенность
                Sinus_B.setToolTipText("Введите коэффицент b");
                jFrame.add(Sinus_B);

                JButton Calc_Sin = new JButton("Синус");
                Calc_Sin.setBounds( 0, 350, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_Sin.setFont(font);
                Calc_Sin.setBackground(Color.black);
                Calc_Sin.setForeground(Color.WHITE);
                Calc_Sin.setFocusPainted(false);
                Calc_Sin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try{
                            Sin_koefK = Double.parseDouble(Sinus_K.getText());
                            Sin_koefB = Double.parseDouble(Sinus_B.getText());
                            Sin_koefD = Double.parseDouble(Sinus_D.getText());
                            Sin_koefPriX = Double.parseDouble(Sinus_PriX.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.1) {
                                func.add(x,  Sin_koefK * Math.sin(Sin_koefPriX * x + Sin_koefD) + Sin_koefB);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }

                    }
                });

                //Cosinus

                JLabel label_Cosinus = new JLabel(" cos( x+ )+");
                label_Cosinus.setBounds(3, 455,dimension.width*45/384, dimension.height*15/432 );
                label_Cosinus.setFont(font_func);
                jFrame.add(label_Cosinus);

                JTextField Cosinus_K = new JTextField();
                Cosinus_K.setBounds(3, 462,15, 17); // кроссплатформенность
                Cosinus_K.setToolTipText("Введите коэффицент k при sqrt");
                jFrame.add(Cosinus_K);

                JTextField Cosinus_PriX = new JTextField();
                Cosinus_PriX.setBounds(69, 462,15, 17); // кроссплатформенность
                Cosinus_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(Cosinus_PriX);

                JTextField Cosinus_D = new JTextField();
                Cosinus_D.setBounds(111, 462,15, 17); // кроссплатформенность
                Cosinus_D.setToolTipText("Введите коэффицент d");
                jFrame.add(Cosinus_D);

                JTextField Cosinus_B = new JTextField();
                Cosinus_B.setBounds(152, 462,15, 17); // кроссплатформенность
                Cosinus_B.setToolTipText("Введите коэффицент b");
                jFrame.add(Cosinus_B);

                JButton Calc_Cos = new JButton("Косинус");
                Calc_Cos.setBounds( 0, 420, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_Cos.setFont(font);
                Calc_Cos.setBackground(Color.black);
                Calc_Cos.setForeground(Color.WHITE);
                Calc_Cos.setFocusPainted(false);
                Calc_Cos.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try{
                            Cos_koefK = Double.parseDouble(Cosinus_K.getText());
                            Cos_koefB = Double.parseDouble(Cosinus_B.getText());
                            Cos_koefD = Double.parseDouble(Cosinus_D.getText());
                            Cos_koefPriX = Double.parseDouble(Cosinus_PriX.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.1) {
                                func.add(x,  Cos_koefK * Math.cos(Cos_koefPriX * x + Cos_koefD) + Cos_koefB);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }

                    }
                });


                // e^x

                JLabel label_e = new JLabel(" e^( x+ )+");
                label_e.setBounds(4, 525,dimension.width*45/384, dimension.height*15/432 );
                label_e.setFont(font_func);
                jFrame.add(label_e);

                JTextField e_K = new JTextField();
                e_K.setBounds(3, 532,15, 17); // кроссплатформенность
                e_K.setToolTipText("Введите коэффицент k при sqrt");
                jFrame.add(e_K);

                JTextField e_PriX = new JTextField();
                e_PriX.setBounds(56, 532,15, 17); // кроссплатформенность
                e_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(e_PriX);

                JTextField e_D = new JTextField();
                e_D.setBounds(98, 532,15, 17); // кроссплатформенность
                e_D.setToolTipText("Введите коэффицент d");
                jFrame.add(e_D);

                JTextField e_B = new JTextField();
                e_B.setBounds(140, 532,15, 17); // кроссплатформенность
                e_B.setToolTipText("Введите коэффицент b");
                jFrame.add(e_B);

                JButton Calc_e = new JButton("Показательная e^x");
                Calc_e.setBounds( 0, 490, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_e.setFont(font);
                Calc_e.setBackground(Color.black);
                Calc_e.setForeground(Color.WHITE);
                Calc_e.setFocusPainted(false);
                Calc_e.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try{
                            e_koefK = Double.parseDouble(e_K.getText());
                            e_koefB = Double.parseDouble(e_B.getText());
                            e_koefD = Double.parseDouble(e_D.getText());
                            e_koefPriX = Double.parseDouble(e_PriX.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.1) {
                                func.add(x,  e_koefK * Math.exp(e_koefPriX * x + e_koefD) + e_koefB);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }

                    }
                });

                // a^x

                JLabel label_aX = new JLabel(" * ^( x+ )+");
                label_aX.setBounds(4, 595,dimension.width*45/384, dimension.height*15/432 );
                label_aX.setFont(font_func);
                jFrame.add(label_aX);

                JTextField aX_K = new JTextField();
                aX_K.setBounds(3, 602,15, 17); // кроссплатформенность
                aX_K.setToolTipText("Введите коэффицент k при sqrt");
                jFrame.add(aX_K);

                JTextField aX_Osn = new JTextField();
                aX_Osn.setBounds(30, 602,15, 17); // кроссплатформенность
                aX_Osn.setToolTipText("Введите коэффицент k при sqrt");
                jFrame.add(aX_Osn);

                JTextField aX_PriX = new JTextField();
                aX_PriX.setBounds(70, 602,15, 17); // кроссплатформенность 56
                aX_PriX.setToolTipText("Введите коэффицент при x");
                jFrame.add(aX_PriX);

                JTextField aX_D = new JTextField();
                aX_D.setBounds(112, 602,15, 17); // кроссплатформенность
                aX_D.setToolTipText("Введите коэффицент d");
                jFrame.add(aX_D);

                JTextField aX_B = new JTextField();
                aX_B.setBounds(154, 602,15, 17); // кроссплатформенность
                aX_B.setToolTipText("Введите коэффицент b");
                jFrame.add(aX_B);

                JButton Calc_aX = new JButton("Показательная a^x");
                Calc_aX.setBounds( 0, 560, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Calc_aX.setFont(font);
                Calc_aX.setBackground(Color.black);
                Calc_aX.setForeground(Color.WHITE);
                Calc_aX.setFocusPainted(false);
                Calc_aX.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try{
                            aX_koefK = Double.parseDouble(aX_K.getText());
                            aX_osnovanie = Double.parseDouble(aX_Osn.getText());
                            aX_koefB = Double.parseDouble(aX_B.getText());
                            aX_koefD = Double.parseDouble(aX_D.getText());
                            aX_koefPriX = Double.parseDouble(aX_PriX.getText());
                            func.clear();//очищаем фанк
                            for (float x = -100; x < 100; x += 0.1) {
                                func.add(x,  aX_koefK * Math.pow(aX_osnovanie, aX_koefPriX * x + aX_koefD) + aX_koefB);
                            }
                            problemUser.setText("");

                        } catch (NumberFormatException e1) {
                            problemUser.setText("<html>Данные введены<br>не корректно</html>");
                        }
                    }
                });


                //frame.add(Calc_Tan);
                jFrame.add(Calc_aX);
                jFrame.add(Calc_e);
                jFrame.add(Calc_Cos);
                jFrame.add(Calc_Sin);
                jFrame.add(Calc_Gip);
                jFrame.add(Calc_Parabola);
                jFrame.add(Calc_Line);
                jFrame.add(Calc_sqrt);
                jFrame.add(Calc_log);
                chartPanel.setLayout(null);


                //это блок для того, чтобы панель располагать в любом песте фрейма
                jFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
                chartPanel.setBounds(dimension.width*49/384, 0, dimension.width - dimension.width*49/384, dimension.height - 60);// dimension.width*35/384 - размер кнопок
                chartPanel.setOpaque(true);
                chartPanel.setLayout(null);
                //frame.setResizable(false);
                jFrame.setLayout(null);
                //frame.setLocationRelativeTo(null);

                jFrame.getContentPane().add(chartPanel);
                jFrame.setSize(dimension.width, dimension.height - 50);

                JButton Return = new JButton("Главное меню");
                Return.setBounds( 0, 630, dimension.width*49/384, dimension.height*15/432); //КРОССПЛАТФОРМЕННОСТЬ
                Return.setFont(font);
                Return.setBackground(Color.black);
                Return.setForeground(Color.WHITE);
                Return.setFocusPainted(false);
                Return.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.getContentPane().removeAll();
                        jFrame.repaint();

                        jFrame.setVisible(true);
                        StartMenu();
                    }
                });
                jFrame.add(Return);
            }
        });
        jFrame.add(Calculator);
        jFrame.setLayout(null);

        JButton OProg = new JButton("О программе");
        OProg.setFont(fontg);
        OProg.setBounds( 20, 20, dimension.width*35/384, dimension.height*15/432);
        OProg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Avtor = new JFrame();
                Avtor.setBounds(20, 50, dimension.width/6, dimension.height/6);
                Avtor.setTitle("О программе");
                Avtor.setVisible(true);

                JLabel label1 = new JLabel("<html>Авторы:<br>Воропаев Артём Дмитриевич<br>Версия: 1.0<br>2024 год</html>");
                label1.setBounds(20, 5, 400, 100);
                Avtor.add(label1);
                Avtor.setLayout(null);
            }
        });
        jFrame.add(OProg);

        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        StartMenu();
    }
    static JFrame getFrame(){ // фукнция, для создания и настройки jFrame

        JFrame jFrame = new JFrame() {}; // создание экземпляра jframe

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // получаем значения разрешения экрана пользователя
        Dimension dimension = toolkit.getScreenSize(); // получаем значения разрешения экрана пользователя

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при нажатии на кнопку закрыть, jrame прекращал свою работу

        jFrame.setBounds(0, 0, dimension.width, dimension.height);
        jFrame.setTitle("Главное меню"); // имя окна, отображающееся пользователю

        return jFrame;
    }
}
