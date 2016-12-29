using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Web;
namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

        }

        private void contextMenuStrip1_Opening(object sender, CancelEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;
            myConnectionString = "server=127.0.0.1;uid=sa;" + "pwd=!password123;database=test;";
            conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
            conn.Open();

            string SQL = richTextBox1.Text;
            try
            {
                MySqlDataReader rdr = null;
                MySqlCommand cmd = new MySqlCommand(SQL, conn);
                rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    richTextBox2.Text += (rdr.GetString(0) + "\t" + rdr.GetString(1) + "\t" + rdr.GetString(2) + "\n");
                }
                rdr.Close();
            }
            catch (Exception e2)
            {
                MessageBox.Show(e2.Message);
            }
            conn.Close();
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;
            myConnectionString = "server=127.0.0.1;uid=sa;" + "pwd=!password123;database=test;";
            conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
            conn.Open();

            string SQL = richTextBox1.Text;
            try
            {
                MySqlDataReader rdr = null;
                MySqlCommand cmd = new MySqlCommand(SQL, conn);
                rdr = cmd.ExecuteReader();
                int x = cmd.ExecuteNonQuery();
                richTextBox2.Text = x + " rows affected";
                rdr.Close();

            }
            catch (Exception e2)
            {
                MessageBox.Show(e2.Message);
            }
            conn.Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            MySql.Data.MySqlClient.MySqlConnection conn;
            string myConnectionString;
            myConnectionString = "server=127.0.0.1;uid=sa;" + "pwd=!password123;database=test;";
            conn = new MySql.Data.MySqlClient.MySqlConnection(myConnectionString);
            conn.Open();

            string SQL = richTextBox1.Text;
            try
            {

                MySqlCommand SCD = new MySqlCommand(richTextBox1.Text, conn);
                // Populate a new data table and bind it to the BindingSource.
                DataTable table = new DataTable();
                table.Locale = System.Globalization.CultureInfo.InvariantCulture;
                MySqlDataAdapter dataAdapter = new MySqlDataAdapter(SCD);
                table.Clear();
                dataAdapter.Fill(table);
                dataGridView1.DataSource = table;
                conn.Close();
            }
            catch (Exception e2)
            {
                MessageBox.Show(e2.Message);
            }
            conn.Close();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void UwithData_Click(object sender, EventArgs e)
        {
            //idk
        }
            public static MySqlDataAdapter CreateCustomerAdapter(MySqlConnection connection)
        {
            MySqlDataAdapter adapter = new MySqlDataAdapter();
            // Create the SelectCommand.
            MySqlCommand command = new MySqlCommand("SELECT * FROM Customers " + "WHERE Country = @Country AND City = @City", connection);
            command.Parameters.Add("@Country", MySqlDbType.VarChar, 15);
            command.Parameters.Add("@City", MySqlDbType.VarChar, 15);
            adapter.SelectCommand = command;
            // Create the InsertCommand.
            command = new MySqlCommand("INSERT INTO Customers (CustomerID, CompanyName) " + "VALUES (@CustomerID, @CompanyName)", connection);
            // Add the parameters for the InsertCommand.
            command.Parameters.Add("@CustomerID", MySqlDbType.VarChar, 5, "CustomerID"); command.Parameters.Add("@CompanyName", MySqlDbType.VarChar, 40, "CompanyName");
            adapter.InsertCommand = command;
            // Create the UpdateCommand.
            command = new MySqlCommand("UPDATE Customers SET CustomerID = @CustomerID, CompanyName = @CompanyName " + "WHERE CustomerID = @oldCustomerID", connection);
            // Add the parameters for the UpdateCommand.
            command.Parameters.Add("@CustomerID", MySqlDbType.VarChar, 5, "CustomerID"); command.Parameters.Add("@CompanyName", MySqlDbType.VarChar, 40, "CompanyName");
            MySqlParameter parameter = command.Parameters.Add(
            "@oldCustomerID", MySqlDbType.VarChar, 5, "CustomerID");
            parameter.SourceVersion = DataRowVersion.Original;
            adapter.UpdateCommand = command;
            // Create the DeleteCommand. 
            command = new MySqlCommand("DELETE FROM Customers WHERE CustomerID = @CustomerID", connection);
            // Add the parameters for the DeleteCommand.
            parameter = command.Parameters.Add("@CustomerID", MySqlDbType.VarChar, 5, "CustomerID"); parameter.SourceVersion = DataRowVersion.Original;
            adapter.DeleteCommand = command;
            return adapter;
        }
    }
}   
    


