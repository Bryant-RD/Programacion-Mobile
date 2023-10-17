import 'package:flutter/material.dart';

void main() {
  runApp(const MainApp());
}

class MainApp extends StatefulWidget {
  const MainApp({super.key});

  @override
  State<MainApp> createState() => _MainAppState();
}

class _MainAppState extends State<MainApp> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        useMaterial3: true,
        colorSchemeSeed: Colors.blueAccent
      ),
      home: Scaffold(
        appBar: AppBar(
          title: const Center(
            child: Text("Contador"),
          ),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text("$contador", style: const TextStyle(fontSize: 140, fontWeight: FontWeight.w100)),
              const Text("clicks", style: TextStyle(fontSize: 25)),

            ],
          )
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {
            
            setState(() {
              contador++;
            });
            
          },
          child: const Icon(Icons.plus_one))
      ),
    );
  }
}
