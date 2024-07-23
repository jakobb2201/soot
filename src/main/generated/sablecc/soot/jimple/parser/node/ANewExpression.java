/* This file was generated by SableCC (http://www.sablecc.org/). */

package soot.jimple.parser.node;

import soot.jimple.parser.analysis.*;

@SuppressWarnings("nls")
public final class ANewExpression extends PExpression
{
    private PNewExpr _newExpr_;

    public ANewExpression()
    {
        // Constructor
    }

    public ANewExpression(
        @SuppressWarnings("hiding") PNewExpr _newExpr_)
    {
        // Constructor
        setNewExpr(_newExpr_);

    }

    @Override
    public Object clone()
    {
        return new ANewExpression(
            cloneNode(this._newExpr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANewExpression(this);
    }

    public PNewExpr getNewExpr()
    {
        return this._newExpr_;
    }

    public void setNewExpr(PNewExpr node)
    {
        if(this._newExpr_ != null)
        {
            this._newExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._newExpr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._newExpr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._newExpr_ == child)
        {
            this._newExpr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._newExpr_ == oldChild)
        {
            setNewExpr((PNewExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
