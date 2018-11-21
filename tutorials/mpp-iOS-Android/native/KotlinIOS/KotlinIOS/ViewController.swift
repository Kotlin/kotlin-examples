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
        
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = CommonKt.createApplicationScreenMessage()
        view.addSubview(label)
    }


}

