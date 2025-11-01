import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val listGender = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Lajang", "Menikah", "Duda/Janda")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Formulir Pendaftaran",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(20.dp))


        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(16.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {


                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text("Nama Lengkap") },
                    placeholder = { Text("Masukkan nama lengkap") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Column {
                    Text("Jenis Kelamin", fontWeight = FontWeight.SemiBold)
                    listGender.forEach { gender ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (jenisKelamin == gender),
                                    onClick = { jenisKelamin = gender }
                                )
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = (jenisKelamin == gender),
                                onClick = { jenisKelamin = gender }
                            )
                            Text(gender)
                        }
                    }
                }


                Column {
                    Text("Status Perkawinan", fontWeight = FontWeight.SemiBold)
                    listStatus.forEach { s ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .selectable(
                                    selected = (status == s),
                                    onClick = { status = s }
                                )
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = (status == s),
                                onClick = { status = s }
                            )
                            Text(s)
                        }
                    }
                }


                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text("Alamat") },
                    placeholder = { Text("Masukkan alamat lengkap") },
                    modifier = Modifier.fillMaxWidth()
                )


                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    enabled = nama.isNotEmpty() && alamat.isNotEmpty()
                ) {
                    Text("Kirim", fontSize = 18.sp)
                }
            }
        }


        if (nama.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))
            ElevatedCard(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF2F2F2)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("📋 Data Pendaftar", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Nama: $nama")
                    Text("Jenis Kelamin: $jenisKelamin")
                    Text("Status: $status")
                    Text("Alamat: $alamat")
                }
            }
        }
    }
}


