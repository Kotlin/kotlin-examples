//
//  ViewController.swift
//  KotlinIOS
//
//  Created by Evgeny Petrenko on 26.09.18.
//  Copyright © 2018 Evgeny Petrenko. All rights reserved.
//

import UIKit
import SharedCode


class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()

        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        label.text = CommonKt.createApplicationScreenMessage()
        label.font = UIFont.systemFont(ofSize: 42.0)
        label.numberOfLines = 0
        label.textAlignment = .center

        view.addSubview(label)

        label.leftAnchor.constraint(equalTo: view.leftAnchor).isActive = true
        label.rightAnchor.constraint(equalTo: view.rightAnchor).isActive = true
        label.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
    }
}
