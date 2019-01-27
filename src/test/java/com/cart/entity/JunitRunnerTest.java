package com.cart.entity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/cucumber/Cart.feature"},plugin = {"pretty"})
public class JunitRunnerTest {

}
