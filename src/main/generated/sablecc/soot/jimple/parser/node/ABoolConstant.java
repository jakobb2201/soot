/* This file was generated by SableCC (http://www.sablecc.org/). */

package soot.jimple.parser.node;

import soot.jimple.parser.analysis.*;

@SuppressWarnings("nls")
public final class ABoolConstant extends PConstant
{
    private TBoolConstant _boolConstant_;

    public ABoolConstant()
    {
        // Constructor
    }

    public ABoolConstant(
        @SuppressWarnings("hiding") TBoolConstant _boolConstant_)
    {
        // Constructor
        setBoolConstant(_boolConstant_);

    }

    @Override
    public Object clone()
    {
        return new ABoolConstant(
            cloneNode(this._boolConstant_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABoolConstant(this);
    }

    public TBoolConstant getBoolConstant()
    {
        return this._boolConstant_;
    }

    public void setBoolConstant(TBoolConstant node)
    {
        if(this._boolConstant_ != null)
        {
            this._boolConstant_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._boolConstant_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._boolConstant_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._boolConstant_ == child)
        {
            this._boolConstant_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._boolConstant_ == oldChild)
        {
            setBoolConstant((TBoolConstant) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
