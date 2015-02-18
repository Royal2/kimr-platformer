package com.kimr.platformer.model;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.kimr.platformer.controller.PlayerController;

/**
 * Created by Student on 2/4/2015.
 */
//implements for interfaces.
public class CollisionListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        //System.out.println("Begin Contact");
        //Getting fixtures (shapes) of box2d.
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        boolean sensorA = fixtureA.isSensor();
        boolean sensorB = fixtureB.isSensor();

        //if(sensorA || sensorB) {
        //    //System.out.println("Fixture A was a sensor.");
        //    PlayerController.grounded = true;
        //    PlayerController.ascended = true;
        //}
        if(sensorA) {
            System.out.println("Fixture A was a sensor.");
            PlayerController.ascended = true;
        }
        if(sensorB) {
            System.out.println("Fixture B was a sensor.");
            PlayerController.grounded = true;
        }
    }

    @Override
    public void endContact(Contact contact) {
        System.out.println("End Contact");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
